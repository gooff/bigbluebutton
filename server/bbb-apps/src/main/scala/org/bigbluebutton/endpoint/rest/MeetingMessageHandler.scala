package org.bigbluebutton.endpoint.rest

import org.bigbluebutton.apps.CreateMeetingResponse
import org.bigbluebutton.meeting._
import org.bigbluebutton.apps.protocol._

trait MeetingMessageHandler {
    def buildJsonResponse(message: CreateMeetingRequestMessage, result: CreateMeetingResponse):CreateMeetingJsonResponse = {
      	  var statusCode = StatusCodeBuilder.buildStatus(StatusCodes.OK)
	      val payload = CreateMeetingResponsePayload(result.success, result.message,
	                                 message.payload.meeting)

	      val response = Response(statusCode)
		  CreateMeetingJsonResponse(message.header, payload)       
    }
    
    def buildJsonFailedResponse(message: CreateMeetingRequestMessage):CreateMeetingJsonResponse = {
	      val statusCode = StatusCodeBuilder.buildStatus(StatusCodes.BAD_REQUEST)
	      val payload = CreateMeetingResponsePayload(false, "Some exception was thrown", message.payload.meeting)
		  val response = Response(statusCode)
		   CreateMeetingJsonResponse(message.header, payload)   
    }
}