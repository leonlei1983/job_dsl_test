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
                                github("leonlei1983/jenkins_pipeline_test", 'https')
                                // credentials('leonlei1983')
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
                                            path('aaa')
                                        }
                                    }
                                }
                            }
                            properties {
                                disableConcurrentBuilds()
                            }
                        }
                    }
                    scriptPath('aaa/Jenkinsfile')
                }
            }

            properties {
                disableConcurrentBuilds()
                pipelineTriggers {
                    triggers {
                        githubPush()
                    }

                    triggers {
                        ghprbTrigger {
                            useGitHubHooks(true)
                            permitAll(true)
                            allowMembersOfWhitelistedOrgsAsAdmin(false)
                            adminlist('')
                            whitelist('')
                            orgslist('')
                            cron('H/5 * * * *')
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

                    triggers {
                        if (name == "example") {
                            upstream("example2", "STABLE")
                        }
                    }
                }
            }

            // triggers {
            //     upstream(pipeline.upstream)
            // }
            // if (name == "example") {
            //     triggers {
            //         upstream("example2")
            //     }
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
