/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.error;

import ratpack.api.NonBlocking;
import ratpack.handling.Context;

/**
 * An object that can deal with errors that occur during the processing of an exchange.
 *
 * Typically retrieved from the exchange service.
 *
 * @see ratpack.handling.Context#error(Throwable)
 */
public interface ServerErrorHandler {

  /**
   * Processes the given exception that occurred processing the given context.
   * <p>
   * Implementations should strive to avoid throwing exceptions.
   * If exceptions are thrown, they will just be logged at a warning level and the response will be finalised with a 500 error code and empty body.
   *
   * @param context The context being processed
   * @param throwable The throwable that occurred
   * @throws Exception if something goes wrong handling the error
   */
  @NonBlocking
  void error(Context context, Throwable throwable) throws Exception;

}
