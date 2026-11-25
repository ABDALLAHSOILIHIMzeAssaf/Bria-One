package org.ldv.briaone.dto.mistral

data class MistralChatRequest(
    val model: String,
    val messages: List<MistralMessage>
)
