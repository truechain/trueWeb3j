package tester;/*
 * Copyright 2019 Web3 Labs LTD.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

import com.trueweb3j.TrueWeb3jRequest;
import com.trueweb3j.common.Constant;
import com.trueweb3j.response.fast.FastBlock;
import org.junit.Test;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.request.ShhFilter;
import org.web3j.protocol.core.methods.request.ShhPost;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.Arrays;

public class RequestTest extends RequestTester {

    private TrueWeb3jRequest trueWeb3jRequest;

    private Web3j web3j;

    @Override
    protected void initWeb3Client(HttpService httpService) {
        this.web3j = Web3j.build(httpService);
        this.trueWeb3jRequest = new TrueWeb3jRequest(httpService);
    }

    @Test
    public void testGetFastBlockByNumber() throws Exception {
        try {
            BigInteger fastNumber = new BigInteger("4962524");
            FastBlock fastBlock = trueWeb3jRequest.getFastBlockByNumber(fastNumber, true);
            System.out.println(fastBlock.getNumberRaw());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWeb3ClientVersion() throws Exception {
        web3j.web3ClientVersion().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"web3_clientVersion\",\"params\":[],\"id\":1}");
    }


}
