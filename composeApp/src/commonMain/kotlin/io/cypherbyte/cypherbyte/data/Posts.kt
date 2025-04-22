package io.cypherbyte.cypherbyte.data

val dummyPosts = listOf(
    BlogPost(
        id = "cve-2022-20465",
        title = "CVE-2022-20465: Binder Root Escalation",
        date = "April 23, 2025",
        content = """
            ## Root via Binder on Android

            This vulnerability allows local privilege escalation via improper handling of binder transactions...

            **Impact**: Full root on vulnerable Android 12 devices.
        """.trimIndent()
    ),
    BlogPost(
        id = "frida-hooking-basics",
        title = "Frida Hooking: Android API Hijack Guide",
        date = "April 22, 2025",
        content = """
            ## Intro to Frida

            Learn how to intercept and manipulate live function calls inside Android apps with Frida.

            - Hook `getDeviceId()`
            - Bypass SSL pinning
        """.trimIndent()
    )
)