package io.ex

import io.common.PipeJob

class Example {
    static def run(factory) {
        def pipeJobGen = {name, closure ->
            PipeJob.run factory, name, closure 
        }

        pipeJobGen("example") {
            if (env.job_enable) {
                disable()
            }
        }
    }
}
