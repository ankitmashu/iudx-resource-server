package iudx.resource.server.common;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import iudx.resource.server.authenticator.model.AuthInfo;
import iudx.resource.server.dataLimitService.handler.DataAccessHandler;
import iudx.resource.server.dataLimitService.model.ConsumedDataInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContextHelper {

  private static final String AUTH_INFO_KEY = "authInfo";
  private static final String CONSUMED_DATA_KEY = "consumedData";
  private static  final String RESPONSE_KEY = "response";
  private static final Logger LOGGER = LogManager.getLogger(ContextHelper.class);

  public static void putAuthInfo(RoutingContext context, AuthInfo authInfo) {
    context.data().put(AUTH_INFO_KEY, authInfo);
  }

  public static AuthInfo getAuthInfo(RoutingContext context) {
    Object value = context.data().get(AUTH_INFO_KEY);
//    LOGGER.info("CONTEXT "+context.data().get(AUTH_INFO_KEY).getClass());
    if (value instanceof AuthInfo) {
      return (AuthInfo) value;
    }
    throw new IllegalStateException(
            "AuthInfo is missing or is of the wrong type in the RoutingContext.");
  }

  public static void putConsumedData(RoutingContext context, ConsumedDataInfo consumedDataInfo) {
    context.data().put(CONSUMED_DATA_KEY, consumedDataInfo);
  }

  public static ConsumedDataInfo getConsumedData(RoutingContext context) {
    Object value = context.data().get(CONSUMED_DATA_KEY);
    if (value instanceof ConsumedDataInfo) {
      return (ConsumedDataInfo) value;
    }
    throw new IllegalStateException(
        "Consumed Data is missing or is of the wrong type in the RoutingContext.");
  }

  public static void putResponse(RoutingContext context, JsonObject jsonResponse) {
    context.data().put(RESPONSE_KEY, jsonResponse);
  }

  public static JsonObject getJsonResponse(RoutingContext context) {
    Object value = context.data().get(RESPONSE_KEY);
    if (value instanceof JsonObject) {
      return (JsonObject) value;
    }
    throw new IllegalStateException(
            "Response is missing or is of the wrong type in the RoutingContext.");
  }
}
