import common

class Example2 {
    static def run(factory) {
        def pipeJobGen = {name, closure ->
            PipeJob.run factory, name, closure 
        }

        pipeJobGen("example2") {}
    }
}