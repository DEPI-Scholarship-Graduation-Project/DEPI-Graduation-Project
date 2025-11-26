# 🧪 Selenium WebDriver Automation Testing Framework

مشروع إطار عمل احترافي لاختبارات الأتمتة باستخدام Selenium WebDriver لموقع Demo Web Shop للتجارة الإلكترونية.

A professional automation testing framework using Selenium WebDriver for the Demo Web Shop e-commerce website.

---

## 📋 جدول المحتويات / Table of Contents

- [المميزات / Features](#المميزات--features)
- [التقنيات المستخدمة / Technologies](#التقنيات-المستخدمة--technologies)
- [المتطلبات / Prerequisites](#المتطلبات--prerequisites)
- [التثبيت والإعداد / Installation](#التثبيت-والإعداد--installation)
- [هيكل المشروع / Project Structure](#هيكل-المشروع--project-structure)
- [كيفية الاستخدام / Usage](#كيفية-الاستخدام--usage)
- [تشغيل الاختبارات / Running Tests](#تشغيل-الاختبارات--running-tests)
- [التقارير / Reports](#التقارير--reports)
- [الإعدادات / Configuration](#الإعدادات--configuration)

---

## ✨ المميزات / Features

- ✅ **Page Object Model (POM)** & **Page Component Object Model (PCOM)**  - نمط تصميم منظم وسهل الصيانة
- ✅ **Multi-Browser Support** - دعم متصفحات Chrome و Edge و Firefox
- ✅ **Headless Mode** - إمكانية تشغيل الاختبارات في الوضع الخفي
- ✅ **TestNG Framework** - إطار عمل قوي لإدارة وتنظيم الاختبارات
- ✅ **Allure Reports** - تقارير تفاعلية وجذابة للاختبارات
- ✅ **JSON Data Driven** - استخدام ملفات JSON لإدارة بيانات الاختبار
- ✅ **Reusable Components** - مكونات قابلة لإعادة الاستخدام (HeaderBar, SideBar)
- ✅ **Utility Classes** - فئات مساعدة للانتظار وقراءة الإعدادات والبيانات
- ✅ **E2E Testing** - اختبارات شاملة من البداية للنهاية
- ✅ **Logging** - نظام تسجيل باستخدام SLF4J و Logback

---

## 🛠 التقنيات المستخدمة / Technologies

| Technology | Description |
|------------|-------------|
| **Java** | لغة البرمجة الأساسية |
| **Maven** | أداة إدارة المشروع والتبعيات |
| **Selenium WebDriver** | إطار عمل أتمتة المتصفح |
| **TestNG** | إطار عمل الاختبارات |
| **Allure** | نظام التقارير التفاعلية |
| **Jackson** | معالجة ملفات JSON |
| **SLF4J & Logback** | نظام التسجيل (Logging) |

---

## 📦 المتطلبات / Prerequisites

قبل البدء، تأكد من تثبيت المتطلبات التالية:

Before starting, make sure you have the following installed:

- ☕ **Java JDK** (الإصدار 8 أو أحدث / Version 8 or higher)
- 🔧 **Maven** (الإصدار 3.6 أو أحدث / Version 3.6 or higher)
- 🌐 **WebDriver** - أحد المتصفحات التالية:
  - Google Chrome + ChromeDriver
  - Microsoft Edge + EdgeDriver
  - Mozilla Firefox + GeckoDriver

### تثبيت WebDriver / Installing WebDriver

يمكنك استخدام WebDriver Manager تلقائياً أو تثبيت WebDriver يدوياً:

You can use WebDriver Manager automatically or install WebDriver manually:

**Chrome:**
```bash
# تحميل ChromeDriver من: https://chromedriver.chromium.org/
# Download ChromeDriver from: https://chromedriver.chromium.org/
```

**Edge:**
```bash
# EdgeDriver يأتي مع Edge تلقائياً
# EdgeDriver comes with Edge automatically
```

**Firefox:**
```bash
# تحميل GeckoDriver من: https://github.com/mozilla/geckodriver/releases
# Download GeckoDriver from: https://github.com/mozilla/geckodriver/releases
```

---

## 🚀 التثبيت والإعداد / Installation

### 1. استنساخ المشروع / Clone the Project

```bash
git clone <repository-url>
cd demo-shop
```

### 2. تثبيت التبعيات / Install Dependencies

```bash
mvn clean install
```

### 3. إعداد ملف الإعدادات / Configure Settings

قم بتعديل ملف `src/main/resources/config.properties` حسب احتياجاتك:

Edit `src/main/resources/config.properties` according to your needs:

```properties
baseUrl=https://demowebshop.tricentis.com/
browser=edge          # chrome, edge, firefox
explicitWait=3
headless=true         # true or false
```

---

## 📁 هيكل المشروع / Project Structure

```
demo-shop/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── components/          # مكونات قابلة لإعادة الاستخدام
│   │   │   │   ├── HeaderBar.java
│   │   │   │   └── SideBar.java
│   │   │   ├── pages/               # صفحات الويب (Page Objects)
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── RegisterPage.java
│   │   │   │   ├── SearchPage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── CheckoutPage.java
│   │   │   │   └── ...
│   │   │   └── utility/             # فئات مساعدة
│   │   │       ├── ConfigReader.java
│   │   │       ├── JsonReader.java
│   │   │       ├── DataGenerator.java
│   │   │       └── ElementWaitUtility.java
│   │   └── resources/
│   │       └── config.properties     # ملف الإعدادات
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java     # فئة الاختبار الأساسية
│       │   └── *Test.java            # فئات الاختبار
│       └── resources/
│           └── testdata/             # بيانات الاختبار
│               ├── loginData.json
│               ├── registerData.json
│               └── productsData.json
├── pom.xml                           # ملف إعدادات Maven
├── AllSuites.xml                     # ملف TestNG Suite
└── README.md
```

---

## 💻 كيفية الاستخدام / Usage

### الاختبارات المتاحة / Available Tests

المشروع يحتوي على الاختبارات التالية:

The project contains the following tests:

- ✅ **LoginTest** - اختبارات تسجيل الدخول
- ✅ **RegisterTest** - اختبارات التسجيل
- ✅ **SearchTest** - اختبارات البحث
- ✅ **HomeTest** - اختبارات الصفحة الرئيسية
- ✅ **CartTest** - اختبارات سلة التسوق
- ✅ **ComputersTest** - اختبارات صفحة الكمبيوترات
- ✅ **ViewProductTest** - اختبارات عرض المنتج
- ✅ **PlaceOrderE2ETest** - اختبار شامل لطلب المنتج
- ✅ **E2ETest** - اختبارات شاملة من البداية للنهاية

---

## 🏃 تشغيل الاختبارات / Running Tests

### تشغيل جميع الاختبارات / Run All Tests

```bash
mvn test
```

### تشغيل TestNG Suite / Run TestNG Suite

```bash
mvn test -DsuiteXmlFile=AllSuites.xml
```

### تشغيل فئة اختبار محددة / Run Specific Test Class

```bash
mvn test -Dtest=LoginTest
```

### تشغيل اختبار محدد / Run Specific Test Method

```bash
mvn test -Dtest=LoginTest#testLogin
```

### تشغيل الاختبارات مع Allure / Run Tests with Allure

```bash
# تشغيل الاختبارات
mvn clean test

# إنشاء تقرير Allure
mvn allure:report

# فتح تقرير Allure في المتصفح
mvn allure:serve
```

---

## 📊 التقارير / Reports

### Allure Reports

المشروع يستخدم Allure لتوليد تقارير تفاعلية وجذابة:

The project uses Allure to generate interactive and attractive reports:

```bash
# بعد تشغيل الاختبارات
mvn test

# إنشاء التقرير
mvn allure:report

# فتح التقرير في المتصفح (سيتم فتحه تلقائياً)
mvn allure:serve
```

التقرير سيكون متاحاً على: `http://localhost:XXXX`

The report will be available at: `http://localhost:XXXX`

### TestNG Reports

تقارير TestNG متاحة في: `target/surefire-reports/`

TestNG reports are available at: `target/surefire-reports/`

---

## ⚙️ الإعدادات / Configuration

### ملف config.properties

```properties
# رابط الموقع الأساسي
baseUrl=https://demowebshop.tricentis.com/

# المتصفح المستخدم (chrome, edge, firefox)
browser=edge

# وقت الانتظار الصريح (بالثواني)
explicitWait=3

# الوضع الخفي (true/false)
headless=true
```


**🔨 Still In Progress**


