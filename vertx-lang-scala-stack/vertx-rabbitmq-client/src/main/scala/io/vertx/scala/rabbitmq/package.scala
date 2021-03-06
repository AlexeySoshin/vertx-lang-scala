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


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.rabbitmq.{RabbitMQConsumer => JRabbitMQConsumer}
import io.vertx.core.streams
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core
import io.vertx.rabbitmq.{RabbitMQMessage => JRabbitMQMessage}
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.core.streams.{WriteStream => JWriteStream}
package object rabbitmq{


  type QueueOptions = io.vertx.rabbitmq.QueueOptions
  object QueueOptions {
    def apply() = new QueueOptions()
    def apply(json: JsonObject) = new QueueOptions(json)
  }




  /**

    */

  implicit class RabbitMQClientScala(val asJava: io.vertx.rabbitmq.RabbitMQClient) extends AnyVal {


    /**
     * Like basicAck from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def basicAckFuture(deliveryTag: java.lang.Long, multiple: java.lang.Boolean) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.basicAck(deliveryTag, multiple, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like basicNack from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def basicNackFuture(deliveryTag: java.lang.Long, multiple: java.lang.Boolean, requeue: java.lang.Boolean) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.basicNack(deliveryTag, multiple, requeue, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like basicGet from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def basicGetFuture(queue: java.lang.String, autoAck: java.lang.Boolean) : scala.concurrent.Future[io.vertx.rabbitmq.RabbitMQMessage] = {
      val promise = concurrent.Promise[io.vertx.rabbitmq.RabbitMQMessage]/*io.vertx.rabbitmq.RabbitMQMessage API*/()
      asJava.basicGet(queue, autoAck, new Handler[AsyncResult[io.vertx.rabbitmq.RabbitMQMessage]] { override def handle(event: AsyncResult[io.vertx.rabbitmq.RabbitMQMessage]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like basicConsumer from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def basicConsumerFuture(queue: java.lang.String) : scala.concurrent.Future[io.vertx.rabbitmq.RabbitMQConsumer] = {
      val promise = concurrent.Promise[io.vertx.rabbitmq.RabbitMQConsumer]/*io.vertx.rabbitmq.RabbitMQConsumer API*/()
      asJava.basicConsumer(queue, new Handler[AsyncResult[io.vertx.rabbitmq.RabbitMQConsumer]] { override def handle(event: AsyncResult[io.vertx.rabbitmq.RabbitMQConsumer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like basicConsumer from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def basicConsumerFuture(queue: java.lang.String, options: io.vertx.rabbitmq.QueueOptions) : scala.concurrent.Future[io.vertx.rabbitmq.RabbitMQConsumer] = {
      val promise = concurrent.Promise[io.vertx.rabbitmq.RabbitMQConsumer]/*io.vertx.rabbitmq.RabbitMQConsumer API*/()
      asJava.basicConsumer(queue, options, new Handler[AsyncResult[io.vertx.rabbitmq.RabbitMQConsumer]] { override def handle(event: AsyncResult[io.vertx.rabbitmq.RabbitMQConsumer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like basicPublish from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def basicPublishFuture(exchange: java.lang.String, routingKey: java.lang.String, body: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.basicPublish(exchange, routingKey, body, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like confirmSelect from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def confirmSelectFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.confirmSelect(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like waitForConfirms from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def waitForConfirmsFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.waitForConfirms(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like waitForConfirms from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def waitForConfirmsFuture(timeout: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.waitForConfirms(timeout, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like basicQos from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def basicQosFuture(prefetchCount: java.lang.Integer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.basicQos(prefetchCount, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like basicQos from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def basicQosFuture(prefetchCount: java.lang.Integer, global: java.lang.Boolean) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.basicQos(prefetchCount, global, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like basicQos from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def basicQosFuture(prefetchSize: java.lang.Integer, prefetchCount: java.lang.Integer, global: java.lang.Boolean) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.basicQos(prefetchSize, prefetchCount, global, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exchangeDeclare from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def exchangeDeclareFuture(exchange: java.lang.String, `type`: java.lang.String, durable: java.lang.Boolean, autoDelete: java.lang.Boolean) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.exchangeDeclare(exchange, `type`, durable, autoDelete, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exchangeDeclare from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def exchangeDeclareFuture(exchange: java.lang.String, `type`: java.lang.String, durable: java.lang.Boolean, autoDelete: java.lang.Boolean, config: io.vertx.core.json.JsonObject) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.exchangeDeclare(exchange, `type`, durable, autoDelete, config, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exchangeDelete from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def exchangeDeleteFuture(exchange: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.exchangeDelete(exchange, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exchangeBind from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def exchangeBindFuture(destination: java.lang.String, source: java.lang.String, routingKey: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.exchangeBind(destination, source, routingKey, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exchangeBind from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def exchangeBindFuture(destination: java.lang.String, source: java.lang.String, routingKey: java.lang.String, arguments: scala.collection.mutable.Map[String, AnyRef]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.exchangeBind(destination, source, routingKey, arguments.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exchangeUnbind from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def exchangeUnbindFuture(destination: java.lang.String, source: java.lang.String, routingKey: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.exchangeUnbind(destination, source, routingKey, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exchangeUnbind from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def exchangeUnbindFuture(destination: java.lang.String, source: java.lang.String, routingKey: java.lang.String, arguments: scala.collection.mutable.Map[String, AnyRef]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.exchangeUnbind(destination, source, routingKey, arguments.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like queueDeclareAuto from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def queueDeclareAutoFuture() : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.queueDeclareAuto(new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like queueBind from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def queueBindFuture(queue: java.lang.String, exchange: java.lang.String, routingKey: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.queueBind(queue, exchange, routingKey, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like queueBind from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def queueBindFuture(queue: java.lang.String, exchange: java.lang.String, routingKey: java.lang.String, arguments: scala.collection.mutable.Map[String, AnyRef]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.queueBind(queue, exchange, routingKey, arguments.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like queueUnbind from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def queueUnbindFuture(queue: java.lang.String, exchange: java.lang.String, routingKey: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.queueUnbind(queue, exchange, routingKey, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like queueUnbind from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def queueUnbindFuture(queue: java.lang.String, exchange: java.lang.String, routingKey: java.lang.String, arguments: scala.collection.mutable.Map[String, AnyRef]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.queueUnbind(queue, exchange, routingKey, arguments.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like messageCount from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def messageCountFuture(queue: java.lang.String) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]/*java.lang.Long BOXED_PRIMITIVE*/()
      asJava.messageCount(queue, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like start from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def startFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.start(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like stop from [[io.vertx.rabbitmq.RabbitMQClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def stopFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.stop(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * A stream of messages from a rabbitmq queue.

    */

  implicit class RabbitMQConsumerScala(val asJava: io.vertx.rabbitmq.RabbitMQConsumer) extends AnyVal {

    /**
     * Set an exception handler on the read stream.     * @param exceptionHandler the exception handler
     * @return a reference to this, so the API can be used fluently
     */
  def exceptionHandler(exceptionHandler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(exceptionHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

    /**
     * Set a message handler. As message appear in a queue, the handler will be called with the message.     * @return a reference to this, so the API can be used fluently
     */
  def handler(messageArrived: scala.Option[io.vertx.rabbitmq.RabbitMQMessage => Unit]) = {
      asJava.handler(messageArrived.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.rabbitmq.RabbitMQMessage]]).getOrElse(null))
  }

    /**
     * Set an end handler. Once the stream has canceled successfully, the handler will be called.     * @return a reference to this, so the API can be used fluently
     */
  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.rabbitmq.RabbitMQMessage]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like cancel from [[io.vertx.rabbitmq.RabbitMQConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def cancelFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.cancel(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }





  type RabbitMQOptions = io.vertx.rabbitmq.RabbitMQOptions
  object RabbitMQOptions {
    def apply() = new RabbitMQOptions()
    def apply(json: JsonObject) = new RabbitMQOptions(json)
  }



}
