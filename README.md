

<div align="center">

# 🏗️ Low Level Design (LLD) Solutions

### Clean, extensible, interview-ready object-oriented designs in Java

![Java](https://img.shields.io/badge/Java-17+-ED8B02?style=for-the-badge&logo=openjdk&logoColor=white)
![Design Patterns](https://img.shields.io/badge/Design%20Patterns-GoF-blue?style=for-the-badge)
![SOLID](https://img.shields.io/badge/Principles-SOLID-success?style=for-the-badge)
![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=for-the-badge)

*Every solution answers the same question: **how would this survive the next three requirement changes?***

</div>

---

## 🎯 About

This repository is a curated collection of **Low Level Design solutions** built for real interview rounds at service-based, product, and FAANG-tier companies, and for anyone who wants to write maintainable object-oriented code.

Each solution focuses on:

- ✅ **Clear requirement scoping**: functional and non-functional, before any code
- ✅ **Clean class design**: well-defined responsibilities and relationships
- ✅ **SOLID-compliant code**: no god classes, no `if-else` ladders
- ✅ **Extensibility**: new features added by *adding* code, not *modifying* it
- ✅ **Concurrency awareness**: thread-safety where the problem demands it
- ✅ **Runnable demos**: every design ships with a `Main` driver you can execute

---


Each problem's README contains:

1. **Requirements** (in scope / out of scope)
2. **Core entities & relationships**
3. **Class diagram** (Mermaid)
4. **Patterns used & why**
5. **Concurrency considerations**
6. **Extension points** ("what if the interviewer asks for X?")

---

## 📚 Problems Covered

| # | Problem | Key Patterns | Difficulty |
|---|---------|--------------|:----------:|
| 1 | Parking Lot | Strategy, Factory, Singleton | 🟢 Easy |
| 2 | Tic-Tac-Toe | State, Strategy | 🟢 Easy |
| 3 | Snake & Ladder | Factory, Observer | 🟢 Easy |
| 4 | Vending Machine | State, Factory | 🟡 Medium |
| 5 | ATM | State, Chain of Responsibility | 🟡 Medium |
| 6 | Elevator System | State, Strategy, Observer | 🔴 Hard |
| 7 | Library Management System | Factory, Observer, Repository | 🟡 Medium |
| 8 | BookMyShow (Movie Ticket Booking) | Strategy, Observer, Locking | 🔴 Hard |
| 9 | Splitwise (Expense Sharing) | Strategy, Factory, Observer | 🟡 Medium |
| 10 | LRU / LFU Cache | Strategy, Doubly Linked List + HashMap | 🟡 Medium |
| 11 | Rate Limiter | Strategy (Token Bucket, Sliding Window) | 🟡 Medium |
| 12 | Notification Service | Observer, Strategy, Factory | 🟡 Medium |
| 13 | Logger Framework | Chain of Responsibility, Singleton | 🟡 Medium |
| 14 | Payment Gateway Abstraction | Adapter, Strategy, Factory | 🔴 Hard |
| 15 | Ride Sharing (Uber/Ola) | Strategy, Observer, State | 🔴 Hard |
| 16 | Food Delivery (Swiggy/Zomato) | Strategy, Observer, State | 🔴 Hard |
| 17 | Chess Game | Strategy, Command, Factory | 🔴 Hard |
| 18 | Hotel Booking System | Factory, Strategy, Locking | 🔴 Hard |
| 19 | URL Shortener | Strategy, Factory | 🟡 Medium |
| 20 | Pub-Sub / Message Queue | Observer, Producer-Consumer | 🔴 Hard |

> 📌 *Add or remove rows as the repo grows. Link each problem name to its folder.*

---

## 🧠 Design Principles

| Principle | Meaning | How it shows up here |
|-----------|---------|----------------------|
| **S**ingle Responsibility | One class, one reason to change | Separate `PricingStrategy`, `PaymentProcessor`, `InventoryService` |
| **O**pen/Closed | Open for extension, closed for modification | New behavior via new strategy classes |
| **L**iskov Substitution | Subtypes must be substitutable | Interfaces with consistent contracts |
| **I**nterface Segregation | Small, focused interfaces | No fat interfaces forcing empty implementations |
| **D**ependency Inversion | Depend on abstractions | Constructor injection throughout |

Also applied: **DRY**, **KISS**, **YAGNI**, **Law of Demeter**, **Composition over Inheritance**.

---

## 🎨 Design Patterns Index

**Creational:** Singleton · Factory Method · Abstract Factory · Builder · Prototype
**Structural:** Adapter · Decorator · Facade · Proxy · Composite
**Behavioral:** Strategy · Observer · State · Command · Chain of Responsibility · Template Method · Iterator

Each pattern is used **only where it solves a real problem**. No pattern-for-pattern's-sake.

---

## 📂 Repository Structure

```
lld-solutions/
├── README.md
├── LICENSE
├── pom.xml
├── docs/
├── parking-lot/
├── tic-tac-toe/
├── elevator-system/
├── bookmyshow/
├── splitwise/
├── rate-limiter/
├── notification-service/
└── ...
```

---

## 🚀 Getting Started


---

## 🎤 Approach to an LLD Interview

A repeatable 6-step framework used across every solution:

1. **Clarify requirements**: ask questions, define scope, state assumptions
2. **Identify entities**: nouns become classes, verbs become methods
3. **Define relationships**: has-a, is-a, uses
4. **Sketch the class diagram**: interfaces first, implementations second
5. **Apply patterns where they earn their place**: not before
6. **Walk through use cases & edge cases**: concurrency, failures, extensibility

> 💡 Full write-up in [`docs/interview-framework.md`](docs/interview-framework.md)

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repo
2. Create a branch: `git checkout -b feature/new-problem`
3. Follow the [folder structure](#-how-each-solution-is-structured)
4. Include a problem `README.md` with requirements and a class diagram
5. Open a Pull Request

**Quality bar:** SOLID-compliant, a runnable `Main`, no hard-coded `if-else` chains for extensible behavior.

---

## ⭐ Support

If this repo helped you crack an interview or level up your design skills, please **star it** ⭐ and share it with a friend who's preparing.

---

## 👩‍💻 Author

Created and maintained by **[Samprita Koley](https://linkedin.com/in/sampritakoley)**
📧 [sampritakoley01@gmail.com](mailto:sampritakoley01@gmail.com)

---

<div align="center">

*Design for change. Code for clarity.*

</div>
