## Content Negotioation in REST Services

REST Services support text/html, text/plain, application/json & application/xml.

A Special annotation `@produces` can be used for specifying what format
content would be converted into before sending it to client.

A special annotation `@consumes` can be used for specifying what format
content would be EXPECTED from client.

Examples:

Produce XML:    `@produces("application/xml")`

Consume XML:    `@consumes("application/xml")`

Produce JSON:   `@produces("application/json")`

Consume JSON:   `@consumes("application/json")`

Produce JSON or XML : `@produces({"application/json","application/xml"})`

Consume JSON or XML : `@consumes({"application/json","application/xml"})`

XML Contents:   To enable conversion of Java Entities into XML Elements
                Use annotation `@XmlRootElement` on Model class

Client Application should use a request header "Accept" to specify response type.
