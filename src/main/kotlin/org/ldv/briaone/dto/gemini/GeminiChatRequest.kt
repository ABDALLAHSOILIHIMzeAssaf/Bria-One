package org.ldv.briaone.dto.gemini

data class GeminiChatRequest(
    val model: String,
    val messages: List<GeminiMessage>
)
