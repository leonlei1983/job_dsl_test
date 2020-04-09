package io.common

class PipeJob {
    boolean disable

    def PipeJob() {

    }

    def disable() {
        disable = true
    }


    static def run(factory, name, closure) {
        def job = new PipeJob()
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.delegate = job
        closure()

        factory.pipelineJob(name) {
            environmentVariables {
                envs(['env': 'staging', 'mode': 'jenkins'])
            }

            // parameters {
            //     booleanParam "open", false
            // }

            definition {
                cpsScm {
                    lightweight(false)
                    scm {
                        git {
                            remote {
                                github("Gogolook-Inc/${pipeline.github.repo}", 'ssh')
                                // credentials('serverdeploy_key')
                                refspec('+refs/pull/${ghprbPullId}/*:refs/remotes/origin/pr/${ghprbPullId}/*')
                            }
                            branch('refs/heads/master')
                            extensions {
                                pruneBranches()
                                wipeOutWorkspace()
                                pathRestriction {
                                    excludedRegions('')
                                    includedRegions("^aaa/.*")
                                }
                                sparseCheckoutPaths {
                                    sparseCheckoutPaths {
                                        sparseCheckoutPath {
                                            path(pipeline.defs.scriptFolder)
                                        }
                                    }
                                }
                            }
                            properties {
                                disableConcurrentBuilds()
                            }
                        }
                    }
                    scriptPath('aaa')
                }
            }

            properties {
                disableConcurrentBuilds()
                pipelineTriggers {
                    triggers {
                        // githubPush()
                        ghprbTrigger {
                            useGitHubHooks(true)
                            permitAll(true)
                            allowMembersOfWhitelistedOrgsAsAdmin(false)
                            adminlist('')
                            whitelist('')
                            orgslist('')
                            // cron('H/5 * * * *')
                            triggerPhrase('')
                            onlyTriggerPhrase(false)
                            autoCloseFailedPullRequests(false)
                            displayBuildErrorsOnDownstreamBuilds(false)
                            commentFilePath('')
                            skipBuildPhrase('.*\\[skip\\W+ci\\].*')
                            blackListCommitAuthor('')
                            msgSuccess('')
                            msgFailure('')
                            commitStatusContext('')
                            gitHubAuthId('')
                            buildDescTemplate('')
                            blackListLabels('')
                            whiteListLabels('')
                            excludedRegions('')
                            includedRegions("^aaa/.*")
                        }
                    }
                }
            }

            // triggers {
            //     upstream(pipeline.upstream)
            // }

            // throttleConcurrentBuilds {

            // }

            logRotator {
                numToKeep(30)
            }

            if (job.disable) {
                disabled()
            }
        }
    }
}
