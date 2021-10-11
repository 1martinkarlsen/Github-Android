package dk.vixo.githubandroid.github.domain.mappers

import dk.vixo.githubandroid.github.data.network.dto.PullRequestDTO
import dk.vixo.githubandroid.github.domain.model.PullRequest
import javax.inject.Inject

class PullRequestDTOToPullRequestMapper @Inject constructor() {

    fun map(dto: PullRequestDTO): PullRequest {
        return with(dto) {
            PullRequest(
                id = id,
                title = title,
                user = user
            )
        }
    }
}