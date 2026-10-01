# 🧪 CoronaDesinfector: a mini Spring style IoC container

A small dependency injection framework written from scratch in plain Java, built to understand what Spring does under the hood. The demo app (a playful "disinfect the room" scenario) is wired together entirely by the container.

![Java](https://img.shields.io/badge/Java-11-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)

## ✨ What the container does

| Feature | How it works |
|---|---|
| **Field injection** | `@InjectByType` fields are filled by asking the `ApplicationContext` for the matching bean |
| **Property injection** | `@InjectProperty` reads values from `application.properties` |
| **Interface resolution** | `JavaConfig` maps interfaces to implementations, falling back to classpath scanning with Reflections |
| **Singletons** | Classes marked `@Singleton` are cached in a `ConcurrentHashMap` and reused |
| **Lifecycle hooks** | Methods annotated `@PostConstruct` run after injection |
| **Proxies** | `@Deprecated` classes are wrapped in a logging proxy: JDK dynamic proxies for interfaces, CGLIB subclasses otherwise |
| **Pluggable pipeline** | New `ObjectConfigurator` and `ProxyConfigurator` implementations are discovered automatically |

## 🏗️ Object creation pipeline

```
getObject(type)
   │
   ├─ cached singleton? ──▶ return it
   │
   ├─ resolve interface → implementation (JavaConfig)
   ├─ instantiate via reflection          (ObjectFactory.create)
   ├─ run every ObjectConfigurator        (inject beans and properties)
   ├─ invoke @PostConstruct methods
   └─ run every ProxyConfigurator         (wrap in a proxy if needed)
```

## ▶️ Run it

```bash
mvn compile exec:java -Dexec.mainClass=com.epam.Main
```

## 💡 What I learned

How reflection, annotations, classpath scanning and dynamic proxies combine to give frameworks like Spring their "magic", and why a pluggable configurator chain keeps the core factory closed for modification but open for extension.
