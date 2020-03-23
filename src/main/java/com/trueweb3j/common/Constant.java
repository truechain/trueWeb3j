package com.trueweb3j.common;

import org.web3j.tx.ChainId;
import org.web3j.utils.Convert;

import java.math.BigInteger;

/**
 * 运行配置项
 */
public class Constant {
    //	public static String RPC_URL = "https://rpc.truescan.net/testnet";

//    public static String RPC_TESTNET_URL = "http://47.92.52.57:8545";

//	public static String RPC_TESTNET_URL = "http://39.100.35.164:8545/";

    public static String RPC_MAINNET_URL = "http://47.108.131.16:8565";
    public static int CHAINID_MAINNET = 19330;

    public static String RPC_TESTNET_URL = "https://rpc.truescan.net/testnet";
    public static int CHAINID_TESTNET = 18928;

    public static BigInteger DEFAULT_GASPRICE = Convert.toWei("2", Convert.Unit.GWEI).toBigInteger();

    public static BigInteger DEFAULT_GASLIMIT = Convert.toWei("21000", Convert.Unit.WEI).toBigInteger();

    public static BigInteger DEFAULT_CONTRACT_GASLIMIT = Convert.toWei("200000", Convert.Unit.WEI).toBigInteger();

    public static BigInteger DEFAULT_VALUE = Convert.toWei("1", Convert.Unit.ETHER).toBigInteger();

    public static BigInteger DEFAULT_FEE = Convert.toWei("1", Convert.Unit.ETHER).toBigInteger();



    public static String BALANCE_CHANGE_BY_SNAIL_NUMBER = "etrue_getBalanceChangeBySnailNumber";

    public static String BLOCK_BYNUMBER = "etrue_getBlockByNumber";

    public static String BLOCK_BYHASH = "etrue_getBlockByHash";

    public static String CURRENT_BLOCK_NUMBER = "etrue_blockNumber";

//    public static String SNAIL_REWARD_CONTENT = "etrue_getSnailRewardContent";

    public static String STAKING_ACCOUNT = "impawn_getStakingAccount";

    public static String ALL_STAKING_ACCOUNT = "impawn_getAllStakingAccount";

    public static String CHAIN_REWARD_CONTENT = "etrue_getChainRewardContent";


    public static String SNAIL_HASH_BY_NUMBER = "etrue_getSnailHashByNumber";

    public static String SNAIL_BLOCK_NUMBER = "etrue_snailBlockNumber";

    public static String SNAIL_BLOCK_BY_HASH = "etrue_getSnailBlockByHash";

    public static String STATE_CHANGE_BY_FAST_NUMBER = "etrue_getStateChangeByFastNumber";

    public static String COMMITTEE_BY_NUMBER = "etrue_getCommittee";

    public static String CURRENT_COMMITTEE_NUMBER = "etrue_committeeNumber";

    public static String SEND_TRUE_RAW_TRANSACTION = "etrue_sendTrueRawTransaction";


}
