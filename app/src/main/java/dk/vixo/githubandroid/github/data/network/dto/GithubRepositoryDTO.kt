package dk.vixo.githubandroid.github.data.network.dto

data class GithubRepositoryDTO(
    val id: Long,
    val name: String,
    val full_name: String,
    val description: String,
    val owner: OwnerDTO,
    val stargazers_count: Long,
    val watchers: Long,
    val pulls_url: String
)

data class OwnerDTO(
    val id: Long,
    val login: String, // Maybe it's the name?
    val avatar_url: String
)