
package com.networknt.tram.todolist.command;

import com.networknt.config.Config;
import com.networknt.server.HandlerProvider;
import io.undertow.Handlers;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Methods;
import com.networknt.info.ServerInfoGetHandler;
import com.networknt.health.HealthGetHandler;

import com.networknt.metrics.prometheus.PrometheusGetHandler;

import com.networknt.tram.todolist.command.handler.*;

public class PathHandlerProvider implements HandlerProvider {
    @Override
    public HttpHandler getHandler() {
        return Handlers.routing()

                .add(Methods.GET, "/v1/health", new HealthGetHandler())

                .add(Methods.POST, "/v1/todos", new TodosPostHandler())

                .add(Methods.GET, "/v1/server/info", new ServerInfoGetHandler())

                .add(Methods.GET, "/v1/prometheus", new PrometheusGetHandler())

                .add(Methods.DELETE, "/v1/todos/{id}", new TodosIdDeleteHandler())

                .add(Methods.PUT, "/v1/todos/{id}", new TodosIdPutHandler())

                ;
    }
}
