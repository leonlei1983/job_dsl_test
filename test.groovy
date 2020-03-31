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

            parameters {
                booleanParam "open", false
            }

            properties {
                disableConcurrentBuilds()
                pipelineTriggers {
                    triggers {
                        githubPush()
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

def pipeJobGen = {name, closure ->
    PipeJob.run this, name, closure 
}

pipeJobGen("example") {
    if (env.open) {
        disable()
    }
}
pipeJobGen("example2") {}

