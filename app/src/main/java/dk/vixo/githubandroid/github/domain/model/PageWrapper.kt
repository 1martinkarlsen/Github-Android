package dk.vixo.githubandroid.github.domain.model

data class PageWrapper<T>(
    val total_count: Long?,
    val incomplete_results: Boolean,
    val items: List<T>
)