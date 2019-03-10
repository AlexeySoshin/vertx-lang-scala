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

package io.vertx.scala.ext.eventbus.bridge

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.eventbus.bridge.tcp.{TcpEventBusBridge => JTcpEventBusBridge}
import io.vertx.core
import io.vertx.ext.eventbus.bridge.tcp.{BridgeEvent => JBridgeEvent}
import io.vertx.ext.bridge
import io.vertx.ext.bridge.{BridgeOptions => JBridgeOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.net
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.core.{Vertx => JVertx}

package object tcp{


  /**
    * Represents an event that occurs on the event bus bridge.
    * 
    * Please consult the documentation for a full explanation.
    */

  implicit class BridgeEventScala(val asJava: io.vertx.ext.eventbus.bridge.tcp.BridgeEvent) extends AnyVal {

    def setFuture(): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.setHandler({a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  /**
    * TCP EventBus bridge for Vert.x
    */

  implicit class TcpEventBusBridgeScala(val asJava: io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge) extends AnyVal {

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(): scala.concurrent.Future[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] = {
      val promise = Promise[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]()
      asJava.listen({a:AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer,address: java.lang.String): scala.concurrent.Future[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] = {
      val promise = Promise[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]()
      asJava.listen(port, address, {a:AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer): scala.concurrent.Future[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] = {
      val promise = Promise[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]()
      asJava.listen(port, {a:AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

}
