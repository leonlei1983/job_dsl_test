package io.ex

import io.common.PipeJob

class Example {
    static def run(factory) {
        def job_enable = "${job_enable}".toBoolean()
        
        def pipeJobGen = {name, closure ->
            PipeJob.run factory, name, closure 
        }

        pipeJobGen("example") {
            if (job_enable) {
                disable()
            }
        }
    }
}
