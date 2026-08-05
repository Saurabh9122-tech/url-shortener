# 🔗 URL Shortener Service

A full-stack URL shortener application with click tracking and analytics built using **Java (Spring Boot)**, **MySQL**, and a responsive frontend dashboard.

---

## 📸 Application Screenshots

![URL Shortener Dashboard](.https://github.com/Saurabh9122-tech/url-shortener/blob/main/url-shortener/Screenshot%202026-08-03%20155439.png
)
*Figure 1: Shortening URLs and viewing real-time click analytics on the dashboard.*

---

## 🚀 Features

* **URL Shortening:** Converts long URLs into unique, 6-character Base62 short codes.
* **Instant Redirection:** Serves high-speed HTTP 302 redirects to target URLs (`/api/r/{code}`).
* **Click Analytics:** Real-time dashboard tracking total clicks per shortened link.
* **RESTful API:** Clean API structure for shortening links and querying analytics programmatically.
* **Responsive Dashboard:** Built-in web interface using HTML5, JavaScript, and Tailwind CSS.

---

## 🛠️ Tech Stack

* **Backend:** Java 17+, Spring Boot 3.x / 4.x, Spring Data JPA
* **Database:** MySQL
* **Frontend:** HTML5, JavaScript (Fetch API), Tailwind CSS
* **Build Tool:** Maven
* **Version Control:** Git & GitHub

---

## 📂 Project Structure

```text
url-shortener/
├── screenshots/         # Application screenshots for README
│   └── dashboard.png
├── src/main/java/com/example/url_shortener/
│   ├── controller/      # REST Endpoints (UrlController.java)
│   ├── model/           # Database Entities (UrlMapping.java)
│   ├── repository/      # JPA Repository (UrlRepository.java)
│   ├── service/         # Business Logic (UrlService.java)
│   └── util/            # Base62 Code Generator (Base62Encoder.java)
└── src/main/resources/
    ├── static/          # Web Interface (index.html)
    └── application.properties
