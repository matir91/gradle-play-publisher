package com.github.triplet.gradle.play.tasks.internal

import com.github.triplet.gradle.play.PlayPublisherExtension
import com.github.triplet.gradle.play.internal.ReleaseStatus
import com.github.triplet.gradle.play.internal.ResolutionStrategy
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.options.Option
import org.gradle.api.tasks.options.OptionValues

internal interface ExtensionOptions {
    @get:Nested val extension: PlayPublisherExtension

    @get:Internal
    @set:Option(
            option = "default-to-app-bundles",
            description = "Prioritize App Bundles over APKs where applicable."
    )
    var defaultToAppBundlesOption: Boolean
        get() = throw UnsupportedOperationException()
        set(value) {
            extension.defaultToAppBundles = value
        }

    @get:Internal
    @set:Option(
            option = "skip-commit",
            description = "Don't commit changes from this build."
    )
    var skipCommitOption: Boolean
        get() = throw UnsupportedOperationException()
        set(value) {
            extension.commit = !value
        }

    @get:Internal
    @set:Option(
            option = "from-track",
            description = "Set the track from which to promote a release."
    )
    var fromTrackOption: String
        get() = throw UnsupportedOperationException()
        set(value) {
            extension.fromTrack = value
        }
    @get:Internal
    @set:Option(
            option = "track",
            description = "Set the track in which to upload your app."
    )
    var trackOption: String
        get() = throw UnsupportedOperationException()
        set(value) {
            extension.track = value
        }

    @get:Internal
    @set:Option(
            option = "user-fraction",
            description = "Set the user fraction intended to receive an 'inProgress' release. " +
                    "Ex: 0.1 == 10%"
    )
    var userFractionOption: String
        get() = throw UnsupportedOperationException()
        set(value) {
            extension.userFraction = value.toDouble()
        }

    @get:OptionValues("resolution-strategy")
    val resolutionStrategyOptions
        get() = ResolutionStrategy.values().map { it.publishedName }
    @get:Internal
    @set:Option(
            option = "resolution-strategy",
            description = "Set the version conflict resolution strategy."
    )
    var resolutionStrategyOption: String
        get() = throw UnsupportedOperationException()
        set(value) {
            extension.resolutionStrategy = value
        }

    @get:OptionValues("release-status")
    val releaseStatusOptions
        get() = ReleaseStatus.values().map { it.publishedName }
    @get:Internal
    @set:Option(
            option = "release-status",
            description = "Set the app release status."
    )
    var releaseStatusOption: String
        get() = throw UnsupportedOperationException()
        set(value) {
            extension.releaseStatus = value
        }
}
