# trueWeb3j
Truechain RPC service interface call based on Web3j

- [QuickStart](https://github.com/truechain/tweb3j-sample/blob/master/src/main/java/com/truechain/QuickStart.java) 
快速开始:判断程序能否连接到truechain网络 rpc节点

RPC interface name and specification:

FastBlock:
getFastBlockByNumber: get FastBlock by fastNumber
getCurrentFastNumber: get current fastNumber on the chain

Address with Balance or Reward:
getStateChangeByFastNumber: get balance change with addresses by fast number
getAddressesSnailReward: get gather addresses snail reward by snailNumber

Staking:
getStakingAccountInfo: get staking info by account
getAllStakingAccount: get all staking account infos 
getChainRewardContent: get the proceeds of all the delegate addresses under a pledge node


SnailBlock:
getSnailBalanceChange: get snail reward address and balance of the address
getSnailRewardContent: get snail reward content,inclued blockminer、fruitminer、committeReward、foundationReward
getSnailBlockByNumber: get snail Block by snailNumber
getSnailBlockByHash: get snailBlock by snailHash
getSnailHashByNumber: get snailHash by snailNumber
getCurrentSnailNumber: get current snail block number


getCommitteeByNumber:  get committeeInfo by committeeNumber
getCurrentCommitteeNumber: get current committee number
etrueSendRawTransaction: send true raw transaction 

