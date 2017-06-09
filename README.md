android-json-rpc
=========

Fork of the original project and modified to handle server side implemented errors.

> Why I did the fork:
> 
> When you get a server side error between -32000 and -32099 the library returned a JSONRPCException and the message got lost.
> Those server side implemented error codes are stated on the [JSON-RPC 2.0 Specification site][1]

Actual [error][4] output:

```
{
    jsonrpc: "2.0",
    error: {
        code: -32014,
        message: "Method not found"
    },
    id: "1"
}
```

Actual [success][5] output:

```
{
    jsonrpc: "2.0",
    result: {
        message: "Everything went fine"
    },
    id: 1
}
```

Login example

```java
JSONRPCClient client = JSONRPCClient.create(URL, JSONRPCParams.Versions.VERSION_2);
client.setConnectionTimeout(2000);
client.setSoTimeout(2000);
try {
    JSONObject jsonObj = new JSONObject();
    jsonObj.put(EXAMPLE_PARAM_1, "myuser");
    jsonObj.put(EXAMPLE_PARAM_2, "mypassword");
    return client.callJSONObject(EXAMPLE_METHOD_NAME, jsonObj);
} catch (JSONRPCException rpcEx) {
    rpcEx.printStackTrace();
} catch (JSONException jsEx) {
    jsEx.printStackTrace();
}
```

Based on
--------

[android-json-rpc-0.3.4][2]

License
----

The MIT License (MIT)

Copyright (c) 2014 Asier

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


**Free Software, Hell Yeah!**

[1]:http://www.jsonrpc.org/specification#error_object
[2]:https://code.google.com/p/android-json-rpc/
[4]:https://raw.githubusercontent.com/axierjhtjz/android-json-rpc/master/error.json
[5]:https://raw.githubusercontent.com/axierjhtjz/android-json-rpc/master/success.json
