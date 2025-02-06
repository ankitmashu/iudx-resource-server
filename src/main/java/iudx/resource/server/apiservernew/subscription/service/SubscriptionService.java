package iudx.resource.server.apiservernew.subscription.service;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import iudx.resource.server.cachenew.service.CacheService;
import iudx.resource.server.databasenew.postgres.service.PostgresService;
import iudx.resource.server.databrokernew.service.DataBrokerService;

/** interface to define all subscription related operation. */
public interface SubscriptionService {

  Future<JsonObject> getSubscription(
      JsonObject json, DataBrokerService databroker, PostgresService pgService);

  Future<JsonObject> createSubscription(
      JsonObject json,
      DataBrokerService databroker,
      PostgresService pgService,
      JsonObject authInfo,
      CacheService cacheService);

  Future<JsonObject> updateSubscription(
      JsonObject json,
      DataBrokerService databroker,
      PostgresService pgService,
      JsonObject authInfo);

  Future<JsonObject> appendSubscription(
      JsonObject json,
      DataBrokerService databroker,
      PostgresService pgService,
      JsonObject authInfo,
      CacheService cacheService);

  Future<JsonObject> deleteSubscription(
      JsonObject json, DataBrokerService databroker, PostgresService pgService);

  Future<JsonObject> getAllSubscriptionQueueForUser(JsonObject json, PostgresService pgService);
}
