/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package io.vertx.scala.ext

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core
import io.vertx.core.metrics
import io.vertx.ext.dropwizard.{MetricsService => JMetricsService}
import io.vertx.core.json.JsonObject
import io.vertx.core.{Vertx => JVertx}
package object dropwizard{


  type DropwizardMetricsOptions = io.vertx.ext.dropwizard.DropwizardMetricsOptions
  object DropwizardMetricsOptions {
    def apply() = new DropwizardMetricsOptions()
    def apply(json: JsonObject) = new DropwizardMetricsOptions(json)
  }



  type Match = io.vertx.ext.dropwizard.Match
  object Match {
    def apply() = new Match()
    def apply(json: JsonObject) = new Match(json)
  }



  object MetricsService {
    /**
     * Creates a metric service for a given [[io.vertx.core.Vertx]] instance.     * @param vertx the vertx instance
     * @return the metrics service
     */
  def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.dropwizard.MetricsService.create(vertx)
  }
  }


}
