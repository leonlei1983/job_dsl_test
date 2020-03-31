package io.ex

import io.common.PipeJob

class Example {
    static def run(factory) {
        def pipeJobGen = {name, closure ->
            PipeJob.run factory, name, closure 
        }

        pipeJobGen("example") {
            if (LEI_MIGRATION == 'false' || job_enable == false) {
                disable()
            }
        }
    }
}
