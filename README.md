# trueWeb3j
Truechain RPC service interface call based on Web3j


RPC interface name and specification:

- [FastBlockUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/FastBlockUsage.java)
1. getFastBlockByNumber: get FastBlock by fastNumber
1. getCurrentFastNumber: get current fastNumber on the chain
1. getStateChangeByFastNumber: 

- [RewardUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/RewardUsage.java)
1. getStateChangeByFastNumber: get balance change with addresses by fast number
1. getAddressesSnailReward: get gather addresses snail reward by snailNumber
1. getSnailBalanceChange: get snail reward address and the balance of the address


- [StakingUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/StakingUsage.java)
1. getStakingAccountInfo: get staking info by account
1. getAllStakingAccount: get all staking account infos 
1. getChainRewardContentByAddress: get the proceeds of all the delegate addresses under a pledge node
1. getChainRewardContent: get the proceeds of all the delegate addresses of all pledge node


- [SnailBlockUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/SnailBlockUsage.java)
1. getSnailBalanceChange: get snail reward address and balance of the address
1. getSnailRewardContent: get snail reward content,inclued blockminer、fruitminer、committeReward、foundationReward
1. getSnailBlockByNumber: get snail Block by snailNumber
1. getSnailBlockByHash: get snailBlock by snailHash
1. getSnailHashByNumber: get snailHash by snailNumber
1. getCurrentSnailNumber: get current snail block number


- [CommitteeUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/CommitteeUsage.java)
1. getCommitteeByNumber:  get committeeInfo by committeeNumber
1. getCurrentCommitteeNumber: get current committee number


- [PaymentTransactionUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/PaymentTransactionUsage.java)
1. sendPaymentTx: send payment transaction
1. signWithFromPrivateKey: sign trueRawTransaction with privateKey of from address :
1. signPaymentTxWithPaymentAndSend: sign signedTxWithFrom with privatekey of payment address:
