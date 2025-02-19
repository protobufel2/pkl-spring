/**
 * Copyright © 2024-2025 Apple Inc. and the Pkl project authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package samples.kotlin

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

@SpringBootApplication
@ConfigurationPropertiesScan
open class Application {
  @Bean
  @Suppress("unused")
  open fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
    return CommandLineRunner {
      val server = ctx.getBean(Server::class.java)
      println(server.config)
    }
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication(Application::class.java).run(*args)
    }
  }
}
