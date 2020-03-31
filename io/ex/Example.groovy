package io.ex

import io.common.PipeJob

def job_enable = "${job_enable}".toBoolean()

class Example {
    static def run(factory) {
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
