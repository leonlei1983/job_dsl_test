def migration = "${LEI_MIGRATION}".toBoolean();

this.pipelineJob('example') {
    environmentVariables {
        envs(['env': 'staging', 'mode': 'jenkins'])
    }
    // parameters {

    // }
    properties {
        disableConcurrentBuilds()
    }
    pipelineTriggers {
        triggers {
            githubPush()
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
    disabled()
}
