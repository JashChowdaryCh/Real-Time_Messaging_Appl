# 💬 Real-Time Messagaing Application with Spring Boot & WebSocket

[🔗 Real-Time Chat App](https://real-time-messaging-app.onrender.com/chat)

A real-time chat application allowing multiple users to communicate simultaneously using **Spring Boot**, **WebSocket**, **STOMP**, and **SockJS**, with a clean UI powered by **Thymeleaf**, **JavaScript**, and **Bootstrap**.

---

## 🎯 Features

- ✅ Real-time message broadcasting
- 👥 Multiple users can chat simultaneously
- 🧾 STOMP over WebSocket architecture
- 🖥️ Dynamic frontend using Thymeleaf
- 📦 Lightweight and browser-compatible via SockJS

---

## 🧰 Tech Stack

### Backend

- Java 21 with Spring Boot
- Spring WebSocket + STOMP protocol
- Lombok for boilerplate-free models
- Thymeleaf template engine

### Frontend

- HTML, CSS, JavaScript
- Bootstrap 5 (CDN)
- SockJS and Stomp.js (CDNs)

---

## 📁 Project Structure

```
src/main/java/com/Real_Time/Messaging/App/ChattingApp
├── config/WebSocketConfig.java
├── controller/ChatController.java
└── model/ChatMessage.java

src/main/resources/templates/chat.html
Dockerfile
```

---

## ⚙️ Setup Instructions

1. **Create Spring Boot project** with the following dependencies:
   - Spring Web
   - WebSocket
   - Thymeleaf
   - Lombok

2. **Clone this repository** and import into IntelliJ or Eclipse.

3. **Run the application**, then go to:
   ```
   http://localhost:8080/chat
   ```

---

## 🧩 WebSocket Flow

1. Client connects to `/chat` endpoint via SockJS
2. Subscribes to `/topic/messages`
3. Sends message to `/app/sendMessage`
4. Spring broadcasts it back via STOMP to `/topic/messages`
5. All connected users receive the message instantly

---

## 📄 Code Snapshots

---

## 🖥️ Frontend (chat.html)

### CDN Scripts

```html
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.1/stomp.min.js"></script>
```


## 📦 External Libraries (CDN)

| Library   | CDN                                                                 |
|-----------|----------------------------------------------------------------------|
| SockJS    | `https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js`   |
| STOMP.js  | `https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.1/stomp.min.js`|

---

## ✅ Test Instructions

- Open multiple browser tabs at [https://real-time-messaging-app.onrender.com/chat](https://real-time-messaging-app.onrender.com/chat)
- Enter different names and start chatting
- Watch real-time updates across all tabs 🎯

---

## 🚀 Deployment on Render

### 🔧 With Dockerfile (Recommended)

Render automatically builds and deploys using your custom `Dockerfile`:

1. Push project (with `Dockerfile`) to GitHub
2. Log in to [Render](https://render.com)
3. Click **"New Web Service"**
4. Connect your GitHub repo
5. Choose **Docker** environment
6. Add environment variable:
   - `PORT=8080`
7. Click **Deploy**

Sample `Dockerfile`:

```Dockerfile
# Stage 1: Build with Maven and Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app in a smaller Java 21 image
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /target/ChattingApp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

### 🔧 CORS Configuration for Render

Update `WebSocketConfig.java` to accept your Render domain:

```java
registry.addEndpoint("/chat")
        .setAllowedOriginPatterns("*")
        .withSockJS();

```

---

## 🔧 Future Enhancements

- 💾 Store chat messages in a database
- 🔐 Add user authentication (Spring Security)
- 📅 Add timestamps to messages
- 🧩 Create room-based chat (`/topic/room1`)
- 🚢 Dockerize & deploy to other clouds (EC2, Railway, etc.)

---
