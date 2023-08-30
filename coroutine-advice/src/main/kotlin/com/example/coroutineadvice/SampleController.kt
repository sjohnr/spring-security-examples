package com.example.coroutineadvice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
open class SampleController {
    @GetMapping("/helloSuspend")
    open suspend fun helloSuspend() : String {
        delay(1)
        return "hello"
    }

    @GetMapping("/helloSuspendDenied")
    open suspend fun helloSuspendDenied() : String {
        delay(1)
        return "heyshouldfail"
    }

    @GetMapping("/helloFlow")
    open suspend fun helloFlow() : Flow<String> {
        return flow {
            emit("hello1")
            emit("hello2")
        }
    }

    @GetMapping("/hello")
    open fun hello() : Mono<String> {
        return Mono.just("hello");
    }

    @GetMapping("/helloDenied")
    open fun helloDenied() : Mono<String> {
        return Mono.just("heyshouldfail");
    }
}
