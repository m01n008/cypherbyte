package io.cypherbyte.cypherbyte.data

data class BlogPost(
    val id: String,          // e.g., "cve-2022-20465"
    val title: String,       // e.g., "CVE-2022-20465: Binder Root Exploit"
    val date: String,        // e.g., "April 23, 2025"
    val content: String      // Markdown or pre-rendered HTML string
)

