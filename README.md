# ⚓ Port Container Management

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/) 
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE) 
[![Repo Size](https://img.shields.io/github/repo-size/sgmad/port-container-management.svg?cacheSeconds=60)](https://github.com/USERNAME/REPO) 
[![Last Commit](https://img.shields.io/github/last-commit/sgmad/port-container-management.svg)](https://github.com/sgmad/port-container-management/commits/main) 

> A menu-driven console application written in Java for academic purposes.  
> It simulates the operations of a small port by managing **containers** and **ships** using ADTs with Java’s `ArrayDeque`.

## 📖 Overview

The system models two main entities:

- **Container** - represents cargo with an ID, description, and weight 
- **Ship** - represents an arriving ship with a name and captain

The port works as follows:
- Containers are stored in a stack (LIFO)
- Ships are handled in a queue (FIFO) 
- Loading pairs the next waiting ship with the top container

## ✨ Key Features

### 1. ADT Classes
- 📦 **Container**: Stores id, description, and weight with formatted `toString()` output  
- 🚢 **Ship**: Stores name and captain with formatted `toString()` output  

### 2. Data Structures
- `ArrayDeque<Container>` → `containerStack` (LIFO: push/pop)  
- `ArrayDeque<Ship>` → `shipQueue` (FIFO: offer/poll)  

### 3. Menu Operations
- [1] Store container (push to stack)  
- [2] View port containers (top to bottom)  
- [3] Register arriving ship (enqueue)  
- [4] View waiting ships (front to rear)  
- [5] Load next ship (pop + poll)  
- [0] Exit  

## 🛠 Implementation Highlights

- ✅ Input validation (handles invalid inputs gracefully)  
- 🔄 Proper LIFO/FIFO behavior:  
  - Containers → `push()` / `pop()`  
  - Ships → `offer()` / `poll()`  
- 🖥 Formatted output matches spec  
- ⚠ Error handling for empty stacks/queues  

## 🚀 Usage Flow

1. Store multiple containers → newest goes on top  
2. Register multiple ships → first arrival is at the front  
3. Load ships → top container goes to front ship  
4. View lists → shows current state  

## 💡 Why This Matters

This program demonstrates practical use of stacks and queues in a real-world-inspired scenario. It’s a straightforward project for learning:

- 🔒 Encapsulation with classes (`Container`, `Ship`)  
- 📊 Data abstraction with stacks and queues  
- 🎛 Menu-driven input handling in Java  
- ⚙ Basic simulation of logistics operations  

## 📸 Screenshots

| Adding 3 containers | Registering 2 ships |
|-------|-------|
| ![Program Screenshot 1](screenshots/1.%20Screenshot%20of%20a%20full%20run%20showing%20at%20least%203%20containers%20added.png) | ![Program Screenshot 2](screenshots/2.%20Screenshot%20of%20a%20full%20run%20showing%201%20ship%20loaded%20successfully.png) |

| Viewing both lists | Loading 1 ship |
|-------|-------|
| ![Program Screenshot 3](screenshots/3.%20Screenshot%20of%20a%20full%20run%20showing%20both%20lists%20being%20viewed.png) | ![Program Screenshot 4](screenshots/4.%20Screenshot%20of%20a%20full%20run%20showing%20at%20least%202%20ships%20registered.png) |
