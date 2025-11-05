# 📧 Mailosaur Email Testing with Java

> Automate your email testing workflow with confidence using Mailosaur

This project demonstrates automated email testing using Mailosaur, a powerful email testing platform that allows you to test email functionality in your applications without sending emails to real addresses.

## 📋 Table of Contents

- [🎯 Overview](#-overview)
- [✅ Prerequisites](#-prerequisites)
- [🚀 Getting Started](#-getting-started)
- [💻 Code Example](#-code-example)
- [⭐ Key Features](#-key-features)
- [📚 Documentation](#-documentation)
- [🎓 Learning Resources](#-learning-resources)
- [👤 Author](#-author)
- [💬 Support](#-support)

## 🎯 Overview

Mailosaur provides a reliable way to test email workflows in your automated tests. It creates virtual email servers that can receive emails, which you can then retrieve and validate programmatically. This is essential for testing:

- ✉️ Email delivery and content
- 🔗 Email links and call-to-action buttons
- 📎 Email attachments
- 🎨 Email formatting (HTML/Text)
- 🔄 Transactional email workflows

## ✅ Prerequisites

Before running the email tests, ensure you have the following:

### 1. 💿 Software Requirements
- **Java Development Kit (JDK)**: Version 8 or higher
- **Maven or Gradle**: For dependency management
- **JUnit**: Version 4.x or 5.x for testing

### 2. 🔐 Mailosaur Account
- Sign up for a Mailosaur account at [https://mailosaur.com](https://mailosaur.com)
- Create a server in your Mailosaur dashboard
- Obtain your API key and Server ID from the dashboard

### 3. 📦 Maven Dependency

Add the Mailosaur Java client to your `pom.xml`:

```xml
<dependency>
    <groupId>com.mailosaur</groupId>
    <artifactId>mailosaur-java</artifactId>
    <version>8.0.0</version>
</dependency>
```

For Gradle, add to your `build.gradle`:

```gradle
implementation 'com.mailosaur:mailosaur-java:8.0.0'
```

### 4. ⚙️ Configuration Details

You'll need three pieces of information from your Mailosaur dashboard:

- **API Key**: Your authentication key (found in the API tab)
- **Server ID**: Your server's unique identifier
- **Server Domain**: Your server's email domain (format: `{serverId}.mailosaur.net`)

## 🚀 Getting Started

### Step 1: 🔑 Set Up Credentials

Replace the placeholder values in the code with your actual Mailosaur credentials:

```java
String apiKey = "YOUR_API_KEY_HERE";
String serverId = "YOUR_SERVER_ID";
String serverDomain = serverId + ".mailosaur.net";
```

### Step 2: 📮 Configure Email Recipient

Send test emails to any address at your server domain:

```
anything@{serverDomain}
```

For example: `test@tcqoyxpz.mailosaur.net`

### Step 3: ▶️ Run the Test

Execute your JUnit test and Mailosaur will automatically retrieve the email for validation.

## 💻 Code Example

Here's a complete example demonstrating email testing with Mailosaur:

```java
package demo;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Link;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class AppTest {
    @Test 
    public void testExample() throws IOException, MailosaurException {
        // 🔐 Available in the API tab of a server
        String apiKey = "YOUR-API-KEY";
        String serverId = "SERVICE-ID";
        String serverDomain = "SERVER-DOMAIN";
        
        MailosaurClient mailosaur = new MailosaurClient(apiKey);
        
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);
        
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo("anything@" + serverDomain);
        
        Message message = mailosaur.messages().get(params, criteria);
        
        // 📧 Email Details
        System.out.println("Subject: " + message.subject());
        System.out.println("From: " + message.from().get(0).email());
        
        // 📄 Body Content
        System.out.println("Body (text): " + message.text().body());
         
        // 🔗 Links
        System.out.println("Total links: " + message.html().links().size());
        Link firstLink = message.html().links().get(0);
        System.out.println("First link URL: " + firstLink.text());
         
        // 📎 Attachments
        System.out.println("Total attachments: " + message.attachments().size());
         	     
        // ✅ Assertions
        assertNotNull(message);
        assertEquals("Mailosour Email Testing", message.subject());
    }
}
```

## ⭐ Key Features

### 🎯 What You Can Test

- **Subject Line Validation**: Verify email subjects match expected values
- **Sender Verification**: Confirm emails are sent from correct addresses
- **Content Validation**: Check both HTML and plain text email bodies
- **Link Extraction**: Retrieve and validate all links in emails
- **Attachment Handling**: Verify attachments are present and accessible
- **Email Metadata**: Access headers, timestamps, and other metadata

### 🚀 Mailosaur Advantages

- ⚡ **Fast Retrieval**: Get emails within seconds
- 🔒 **Secure Testing**: No real email accounts needed
- 🌐 **Spam Filter Free**: All emails guaranteed to arrive
- 📱 **Multi-Format Support**: Test HTML and plain text emails
- 🔄 **API-First Design**: Perfect for automation and CI/CD pipelines

## 📚 Documentation

For comprehensive documentation and advanced features, visit:

- **Official Java Documentation**: [https://mailosaur.com/docs/languages/java](https://mailosaur.com/docs/languages/java)
- **API Reference**: [https://mailosaur.com/docs/api](https://mailosaur.com/docs/api)
- **Getting Started Guide**: [https://mailosaur.com/docs](https://mailosaur.com/docs)

## 🎓 Learning Resources

Want to learn more about email testing with Mailosaur? Check out this comprehensive video tutorial:

### 📺 Video Tutorial
**Mailosaur Email Testing - Complete Guide**

[![Mailosaur Tutorial](https://img.shields.io/badge/YouTube-Watch%20Tutorial-red?style=for-the-badge&logo=youtube)](https://youtu.be/Il8efgsiJyw?si=hde9klGlYEdHNmYr)

🔗 [https://youtu.be/Il8efgsiJyw?si=hde9klGlYEdHNmYr](https://youtu.be/Il8efgsiJyw?si=hde9klGlYEdHNmYr)

This tutorial covers:
- Setting up Mailosaur for the first time
- Integrating with Java test automation
- Real-world testing scenarios
- Best practices and tips

## 👤 Author

**Saran Kumar**

---

## 💬 Support
