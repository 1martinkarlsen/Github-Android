package dk.vixo.githubandroid.github.data.network.dto

data class PullRequestDTO(
    val id: Long,
    val title: String,
    val user: OwnerDTO
)