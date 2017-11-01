package com.example.android.findabook;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Emma Buchheim on 10/30/2017.
 */

public final class QueryUtils {

    private static String SAMPLE_JSON_RESPONSE = "{\n" +
            " \"kind\": \"books#volumes\",\n" +
            " \"totalItems\": 3068,\n" +
            " \"items\": [\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"oVw4DQAAQBAJ\",\n" +
            "   \"etag\": \"k1CyPwmINAE\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/oVw4DQAAQBAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Beginning Android Programming with Android Studio\",\n" +
            "    \"authors\": [\n" +
            "     \"Jerome F. DiMarzio\"\n" +
            "    ],\n" +
            "    \"publisher\": \"John Wiley & Sons\",\n" +
            "    \"publishedDate\": \"2016-10-06\",\n" +
            "    \"description\": \"A hands-on introduction to the latest release of the Android OS and the easiest Android tools for developers As the dominant mobile platform today, the Android OS is a powerful and flexible platform for mobile device. The new Android 7 release (New York Cheesecake) boasts significant new features and enhancements for both smartphone and tablet applications. This step-by-step resource takes a hands-on approach to teaching you how to create Android applications for the latest OS and the newest devices, including both smartphones and tablets. Shows you how to install, get started with, and use Android Studio 2 - the simplest Android developer tool ever for beginners Addresses how to display notifications, create rich user interfaces, and use activities and intents Reviews mastering views and menus and managing data Discusses working with SMS Looks at packaging and publishing applications to the Android market Beginning Android Programming with Android Studio starts with the basics and goes on to provide you with everything you need to know to begin to successfully develop your own Android applications.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781119196099\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1119196094\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 456,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"0.1.1.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=oVw4DQAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=oVw4DQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=oVw4DQAAQBAJ&printsec=frontcover&dq=android&hl=&cd=1&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=oVw4DQAAQBAJ&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-oVw4DQAAQBAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 25.99,\n" +
            "     \"currencyCode\": \"USD\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 20.79,\n" +
            "     \"currencyCode\": \"USD\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=oVw4DQAAQBAJ&rdid=book-oVw4DQAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 2.599E7,\n" +
            "       \"currencyCode\": \"USD\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 2.079E7,\n" +
            "       \"currencyCode\": \"USD\"\n" +
            "      },\n" +
            "      \"giftable\": true\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Beginning_Android_Programming_with_Andro-sample-epub.acsm?id=oVw4DQAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Beginning_Android_Programming_with_Andro-sample-pdf.acsm?id=oVw4DQAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=oVw4DQAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"This book offers hands-on instruction backed by real-world examples to provide the quickest route to productivity.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"zDibrpXTfxMC\",\n" +
            "   \"etag\": \"ziSp7zM67CY\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/zDibrpXTfxMC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android Forensics\",\n" +
            "    \"subtitle\": \"Investigation, Analysis, and Mobile Security for Google Android\",\n" +
            "    \"authors\": [\n" +
            "     \"Andrew Hoog\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Elsevier\",\n" +
            "    \"publishedDate\": \"2011\",\n" +
            "    \"description\": \"The open source nature of the platform has not only established a new direction for the industry, but enables a developer or forensic analyst to understand the device at the most fundamental level. Android Forensics covers an open source mobile device platform based on the Linux 2.6 kernel and managed by the Open Handset Alliance. The Android platform is a major source of digital forensic investigation and analysis. This book provides a thorough review of the Android platform including supported hardware devices, the structure of the Android development project and implementation of core services (wireless communication, data storage and other low-level functions). Finally, it will focus on teaching readers how to apply actual forensic techniques to recover data. Ability to forensically acquire Android devices using the techniques outlined in the book Detailed information about Android applications needed for forensics investigations Important information about SQLite, a file based structured data storage relevant for both Android and many other platforms.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781597496513\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1597496510\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 372,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"preview-1.0.0\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=zDibrpXTfxMC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=zDibrpXTfxMC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=zDibrpXTfxMC&printsec=frontcover&dq=android&hl=&cd=2&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.com/books?id=zDibrpXTfxMC&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_Forensics.html?hl=&id=zDibrpXTfxMC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=zDibrpXTfxMC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"This book provides a thorough review of the Android platform including supported hardware devices, the structure of the Android development project and implementation of core services (wireless communication, data storage and other low ...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"ZthJlG4o-2wC\",\n" +
            "   \"etag\": \"VddEGdcHkSA\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/ZthJlG4o-2wC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Professional Android 2 Application Development\",\n" +
            "    \"authors\": [\n" +
            "     \"Reto Meier\"\n" +
            "    ],\n" +
            "    \"publisher\": \"John Wiley & Sons\",\n" +
            "    \"publishedDate\": \"2010-11-04\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9780470874516\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"0470874511\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 576,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"averageRating\": 3.0,\n" +
            "    \"ratingsCount\": 2,\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"0.17.8.0.preview.3\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=ZthJlG4o-2wC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=ZthJlG4o-2wC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=ZthJlG4o-2wC&printsec=frontcover&dq=android&hl=&cd=3&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.com/books?id=ZthJlG4o-2wC&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Professional_Android_2_Application_Devel.html?hl=&id=ZthJlG4o-2wC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Professional_Android_2_Application_Devel-sample-epub.acsm?id=ZthJlG4o-2wC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Professional_Android_2_Application_Devel-sample-pdf.acsm?id=ZthJlG4o-2wC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=ZthJlG4o-2wC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Programmer Forums Join our Programmer to Programmer forums to ask and answer programming questions about this book, join discussions on the hottest topics in the industry, and connect with fellow programmers from around the world.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"AO9RCgAAQBAJ\",\n" +
            "   \"etag\": \"JBiVFHQ7StM\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/AO9RCgAAQBAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Expert Android Studio\",\n" +
            "    \"authors\": [\n" +
            "     \"Murat Yener\",\n" +
            "     \"Onur Dundar\"\n" +
            "    ],\n" +
            "    \"publisher\": \"John Wiley & Sons\",\n" +
            "    \"publishedDate\": \"2016-09-13\",\n" +
            "    \"description\": \"Unleash Android Studio to go far beyond the ordinary application Expert Android Studio bridges the gap between your Android programing skills with the provided tools including Android Studio, NDK, Gradle and Plugins for IntelliJ Idea Platform. Packed with best practices and advanced tips and techniques on Android tools, development cycle, continuous integration, release management, testing, and performance, this book offers professional guidance to experienced developers who want to push the boundaries of the Android platform with the developer tools. You'll discover how to use the tools and techniques to unleash your true potential as a developer. Discover the basics of working in Android Studio and Gradle®, as well as the application architecture of the latest Android platform Understand Native Development Kit and its integration with Android Studio Complete your development lifecycle with automated tests, dependency management, continuous integration and release management Writing your own Gradle plugins to customize build cycle Writing your own plugins for Android Studio to help your development tasks. Expert Android Studio is a tool for expert and experienced developers who want to learn how to make use of the tools while creating Android applications for use on mobile devices. Wrox Expert books present the wisdom accumulated by an experienced author team who is recognized as experts by the programming community. These experts challenge professional developers to examine their current practices in pursuit of better results.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781119089254\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1119089255\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 456,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"1.4.1.0.preview.1\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=AO9RCgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=AO9RCgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=AO9RCgAAQBAJ&printsec=frontcover&dq=android&hl=&cd=4&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.com/books?id=AO9RCgAAQBAJ&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Expert_Android_Studio.html?hl=&id=AO9RCgAAQBAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=AO9RCgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Packed with best practices and advanced tips and techniques on Android tools, development cycle, continuous integration, release management, testing, and performance, this book offers professional guidance to experienced developers who want ...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"2XeNswkT_2YC\",\n" +
            "   \"etag\": \"akiiHznwvQ4\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/2XeNswkT_2YC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Beginning Android 2\",\n" +
            "    \"authors\": [\n" +
            "     \"Mark Murphy\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Apress\",\n" +
            "    \"publishedDate\": \"2010-03-19\",\n" +
            "    \"description\": \"The Android development platform, created by Google and the Open Handset Alliance, is a platform in its truest sense, encompassing hundreds of classes beyond the traditional Java classes and open source components that ship with the SDK. With Beginning Android 2, you’ll learn how to develop applications for Android 2.x mobile devices, using simple examples that are ready to run with your copy of the software development kit. Author, Android columnist, writer, developer, and community advocate Mark L. Murphy will show you what you need to know to get started programming Android applications, including how to craft graphical user interfaces, use GPS, and access web services. What you’ll learn Discover Android and how to use it to build Java-based mobile applications for a wide range of phones and other devices. Create user interfaces using both the Android widget framework and the built-in WebKit-powered Web browser components. Utilize the distinctive capabilities of the Android engine, including location tracking, maps, and Internet access. Use and create Android applications incorporating activities, services, content providers, and broadcast receivers. Support Android 1.5, 1.6, and 2.0 devices, including dealing with multiple Android OS versions, multiple screen sizes, and other device-specific characteristics. Who this book is for This book is aimed at people new to mobile development, but with some knowledge of Java. Table of Contents The Big Picture Projects & Targets Creating a Skeleton Application Using XML-Based Layouts Employing Basic Widgets Working with Containers Using Selection Widgets Getting Fancy With Lists Employing Fancy Widgets and Containers The Input Method Framework Applying Menus Fonts Embedding the WebKit Browser Showing Pop-Up Messages Dealing with Threads Handling Activity Lifecycle Events Creating Intent Filters Launching Activities and Sub-Activities Handling Rotation Working with Resources Using Preferences Managing and Accessing Local Databases Accessing Files Leveraging Java Libraries Communicating via the Internet Using a Content Provider Building a Content Provider Requesting and Requiring Permissions Creating a Service Invoking a Service Alerting Users Via Notifications Accessing Location-Based Services Mapping with MapView and MapActivity Handling Telephone Calls Development Tools Handling Multiple Screen Sizes Dealing with Devices Handling Platform Changes Where Do We Go From Here?\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781430226291\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1430226293\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 416,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"averageRating\": 2.0,\n" +
            "    \"ratingsCount\": 2,\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"1.3.3.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=2XeNswkT_2YC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=2XeNswkT_2YC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=2XeNswkT_2YC&pg=PA180&dq=android&hl=&cd=5&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.com/books?id=2XeNswkT_2YC&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Beginning_Android_2.html?hl=&id=2XeNswkT_2YC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Beginning_Android_2-sample-epub.acsm?id=2XeNswkT_2YC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Beginning_Android_2-sample-pdf.acsm?id=2XeNswkT_2YC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=2XeNswkT_2YC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"\\u003cb\\u003eandroid\\u003c/b\\u003e :layout_weight=&quot;l&quot; /&gt; &lt;EditText \\u003cb\\u003eandroid\\u003c/b\\u003e :id=&quot;@+id/lon&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e : \\u003cbr\\u003e\\nlayout_width=&quot;f ill_parent &quot; \\u003cb\\u003eandroid\\u003c/b\\u003e : layout_height=&quot;wrap_content&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e :\\u003cbr\\u003e\\ncursorVisible= &quot;true&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e :editable=&quot;true&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e : singlel_ine=&quot;true&quot; \\u003cb\\u003eandroid\\u003c/b\\u003e\\u003cbr\\u003e\\n&nbsp;...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"lwklCgAAQBAJ\",\n" +
            "   \"etag\": \"O/ccg6EvzP0\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/lwklCgAAQBAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android Application Development All-in-One For Dummies\",\n" +
            "    \"authors\": [\n" +
            "     \"Barry A. Burd\"\n" +
            "    ],\n" +
            "    \"publisher\": \"John Wiley & Sons\",\n" +
            "    \"publishedDate\": \"2015-07-09\",\n" +
            "    \"description\": \"Your all-encompassing guide to learning Android app development If you're an aspiring or beginning programmer interested in creating apps for the Android market—which grows in size and downloads every day—this is your comprehensive, one-stop guide. Android Application Development All-in-One For Dummies covers the information you absolutely need to get started developing apps for Android. Inside, you'll quickly get up to speed on Android programming concepts and put your new knowledge to use to manage data, program cool phone features, refine your applications, navigate confidently around the Android native development kit, and add important finishing touches to your apps. Covering the latest features and enhancements to the Android Software Developer's Kit, this friendly, hands-on guide walks you through Android programming basics, shares techniques for developing great Android applications, reviews Android hardware, and much more. All programming examples, including the sample application, are available for download from the book's website Information is carefully organized and presented in an easy-to-follow format 800+ pages of content make this an invaluable resource at an unbeatable price Written by an expert Java educator, Barry Burd, who authors the bestselling Java For Dummies Go from Android newbie to master programmer in no time with the help of Android Application Development All-in-One For Dummies!\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781118973844\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1118973844\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 768,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"1.9.6.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=lwklCgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=lwklCgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=lwklCgAAQBAJ&printsec=frontcover&dq=android&hl=&cd=6&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=lwklCgAAQBAJ&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-lwklCgAAQBAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 25.99,\n" +
            "     \"currencyCode\": \"USD\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 20.79,\n" +
            "     \"currencyCode\": \"USD\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=lwklCgAAQBAJ&rdid=book-lwklCgAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 2.599E7,\n" +
            "       \"currencyCode\": \"USD\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 2.079E7,\n" +
            "       \"currencyCode\": \"USD\"\n" +
            "      },\n" +
            "      \"giftable\": true\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Android_Application_Development_All_in_O-sample-epub.acsm?id=lwklCgAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Android_Application_Development_All_in_O-sample-pdf.acsm?id=lwklCgAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=lwklCgAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"All programming examples, including the sample application, are available for download from the book&#39;s website Information is carefully organized and presented in an easy-to-follow format 800+ pages of content make this an invaluable ...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"W6vrklcPTegC\",\n" +
            "   \"etag\": \"96UgUeZnWJ0\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/W6vrklcPTegC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Pro Android 4\",\n" +
            "    \"authors\": [\n" +
            "     \"Satya Komatineni\",\n" +
            "     \"Dave MacLean\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Apress\",\n" +
            "    \"publishedDate\": \"2012-06-12\",\n" +
            "    \"description\": \"Pro Android 4 shows you how to build real-world and fun mobile apps using the new Android SDK 4 (Ice Cream Sandwich), which unifies Gingerbread for smartphones, Honeycomb for tablets and augments further with Google TV and more. This Android 4 book updates the best selling Pro Android 3 and covers everything from the fundamentals of building apps for embedded devices, smartphones, and tablets to advanced concepts such as custom 3D components, multi-tasking, sensors/augmented reality, better accessories support and much more. Using the tutorials and expert advice, you'll quickly be able to build cool mobile apps and run them on dozens of Android-based smartphones. You'll explore and use the Android APIs, including those for media and sensors. And you'll check out what's new with Android 4, including the improved user interface across all Android platforms, integration with services, and more. After reading this definitive tutorial and reference, you gain the knowledge and experience to create stunning, cutting-edge Android 4 apps that can make you money, while keeping you agile enough to respond to changes in the future.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781430239314\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"143023931X\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 1020,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"3.5.4.0.preview.3\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=W6vrklcPTegC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=W6vrklcPTegC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=W6vrklcPTegC&printsec=frontcover&dq=android&hl=&cd=7&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=W6vrklcPTegC&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-W6vrklcPTegC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 49.99,\n" +
            "     \"currencyCode\": \"USD\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 39.49,\n" +
            "     \"currencyCode\": \"USD\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=W6vrklcPTegC&rdid=book-W6vrklcPTegC&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 4.999E7,\n" +
            "       \"currencyCode\": \"USD\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 3.949E7,\n" +
            "       \"currencyCode\": \"USD\"\n" +
            "      },\n" +
            "      \"giftable\": true\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Pro_Android_4-sample-epub.acsm?id=W6vrklcPTegC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Pro_Android_4-sample-pdf.acsm?id=W6vrklcPTegC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=W6vrklcPTegC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"This Android 4 book updates the best selling Pro Android 3 and covers everything from the fundamentals of building apps for embedded devices, smartphones, and tablets to advanced concepts such as custom 3D components, multi-tasking, ...\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"tsRhkvo80iUC\",\n" +
            "   \"etag\": \"ZBx0cgf2r6I\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/tsRhkvo80iUC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"The Android Invasion\",\n" +
            "    \"authors\": [\n" +
            "     \"Christopher Black\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Yearling\",\n" +
            "    \"publishedDate\": \"1984-06-01\",\n" +
            "    \"description\": \"In this multiple plot adventure, readers and their robot companion must stop armies of attacking androids before they conquer the galaxy.\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"0440400813\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9780440400813\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": false\n" +
            "    },\n" +
            "    \"pageCount\": 117,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Androids\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"0.0.1.0.preview.0\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=tsRhkvo80iUC&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=tsRhkvo80iUC&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=tsRhkvo80iUC&q=android&dq=android&hl=&cd=8&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.com/books?id=tsRhkvo80iUC&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Android_Invasion.html?hl=&id=tsRhkvo80iUC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"NO_PAGES\",\n" +
            "    \"embeddable\": false,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=tsRhkvo80iUC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"NONE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"In this multiple plot adventure, readers and their robot companion must stop armies of attacking androids before they conquer the galaxy.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"H8tNBKmPO5UC\",\n" +
            "   \"etag\": \"zr7PPCN1JOU\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/H8tNBKmPO5UC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android Fully Loaded\",\n" +
            "    \"authors\": [\n" +
            "     \"Rob Huddleston\"\n" +
            "    ],\n" +
            "    \"publisher\": \"John Wiley & Sons\",\n" +
            "    \"publishedDate\": \"2012-08-03\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781118234914\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"111823491X\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 256,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"2.2.2.0.preview.3\",\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=H8tNBKmPO5UC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=H8tNBKmPO5UC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=H8tNBKmPO5UC&printsec=frontcover&dq=android&hl=&cd=9&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.com/books?id=H8tNBKmPO5UC&dq=android&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Android_Fully_Loaded.html?hl=&id=H8tNBKmPO5UC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Android_Fully_Loaded-sample-epub.acsm?id=H8tNBKmPO5UC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Android_Fully_Loaded-sample-pdf.acsm?id=H8tNBKmPO5UC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=H8tNBKmPO5UC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Get Android Fully Loaded, Second Edition and don&#39;t miss a thing! Take your love affair with Android to a new level Since the first edition of this book, new phones and new apps have been popping up like monsters at the game-master&#39;s level.\"\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"QxZMDQAAQBAJ\",\n" +
            "   \"etag\": \"QhmDmmr5OGI\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/QxZMDQAAQBAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Java Programming for Android Developers For Dummies\",\n" +
            "    \"authors\": [\n" +
            "     \"Barry A. Burd\"\n" +
            "    ],\n" +
            "    \"publisher\": \"John Wiley & Sons\",\n" +
            "    \"publishedDate\": \"2016-10-19\",\n" +
            "    \"description\": \"Develop the next killer Android App using Java programming! Android is everywhere! It runs more than half the smartphones in the U.S.—and Java makes it go. If you want to cash in on its popularity by learning to build Android apps with Java, all the easy-to-follow guidance you need to get started is at your fingertips. Inside, you'll learn the basics of Java and grasp how it works with Android; then, you'll go on to create your first real, working application. How cool is that? The demand for Android apps isn't showing any signs of slowing, but if you're a mobile developer who wants to get in on the action, it's vital that you get the necessary Java background to be a success. With the help of Java Programming for Android Developers For Dummies, you'll quickly and painlessly discover the ins and outs of using Java to create groundbreaking Android apps—no prior knowledge or experience required! Get the know-how to create an Android program from the ground up Make sense of basic Java development concepts and techniques Develop the skills to handle programming challenges Find out how to debug your app Don't sit back and watch other developers release apps that bring in the bucks! Everything you need to create that next killer Android app is just a page away!\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781119301127\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1119301122\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": true\n" +
            "    },\n" +
            "    \"pageCount\": 456,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Computers\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": true,\n" +
            "    \"contentVersion\": \"0.1.0.0.preview.1\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=QxZMDQAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=QxZMDQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=QxZMDQAAQBAJ&printsec=frontcover&dq=android&hl=&cd=10&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=QxZMDQAAQBAJ&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-QxZMDQAAQBAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 22.99,\n" +
            "     \"currencyCode\": \"USD\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 18.39,\n" +
            "     \"currencyCode\": \"USD\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=QxZMDQAAQBAJ&rdid=book-QxZMDQAAQBAJ&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 2.299E7,\n" +
            "       \"currencyCode\": \"USD\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 1.839E7,\n" +
            "       \"currencyCode\": \"USD\"\n" +
            "      },\n" +
            "      \"giftable\": true\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.com/books/download/Java_Programming_for_Android_Developers-sample-pdf.acsm?id=QxZMDQAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=QxZMDQAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"With the help of Java Programming for Android Developers For Dummies, you&#39;ll quickly and painlessly discover the ins and outs of using Java to create groundbreaking Android apps—no prior knowledge or experience required!\"\n" +
            "   }\n" +
            "  }\n" +
            " ]\n" +
            "}";

    private QueryUtils() {

    }

    public static ArrayList<Book> parseBooks (String bookJSON) {

        //if the JSON string is empty or null, return early
        if (TextUtils.isEmpty(bookJSON)) {
            return null;
        }

        //Create an array list of books that we can add new books
        ArrayList<Book> books = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(bookJSON);
            JSONArray bookItems = root.getJSONArray("items");

            for (int i = 0; i < bookItems.length(); i++) {
                JSONObject bookItem = bookItems.getJSONObject(i);
                JSONObject bookVolumeInfo = bookItem.getJSONObject("volumeInfo");
                String bookTitle = bookVolumeInfo.getString("title");
                JSONArray bookAuthors = bookVolumeInfo.getJSONArray("authors");

            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the book JSON results", e);
        }

        return books;

    }

}
