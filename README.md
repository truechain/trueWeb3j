# trueWeb3j
Truechain RPC service interface call based on Web3j


RPC interface name and specification:

- [FastBlockUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/FastBlockUsage.java)
getFastBlockByNumber: get FastBlock by fastNumber
getCurrentFastNumber: get current fastNumber on the chain
getStateChangeByFastNumber: 

- [RewardUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/RewardUsage.java)
getStateChangeByFastNumber: get balance change with addresses by fast number
getAddressesSnailReward: get gather addresses snail reward by snailNumber
getSnailBalanceChange: get snail reward address and the balance of the address


- [StakingUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/StakingUsage.java)
getStakingAccountInfo: get staking info by account
getAllStakingAccount: get all staking account infos 
getChainRewardContentByAddress: get the proceeds of all the delegate addresses under a pledge node
getChainRewardContent: get the proceeds of all the delegate addresses of all pledge node


- [SnailBlockUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/SnailBlockUsage.java)
getSnailBalanceChange: get snail reward address and balance of the address
getSnailRewardContent: get snail reward content,inclued blockminer、fruitminer、committeReward、foundationReward
getSnailBlockByNumber: get snail Block by snailNumber
getSnailBlockByHash: get snailBlock by snailHash
getSnailHashByNumber: get snailHash by snailNumber
getCurrentSnailNumber: get current snail block number


- [CommitteeInfoUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/CommitteeInfoUsage.java)
getCommitteeByNumber:  get committeeInfo by committeeNumber
getCurrentCommitteeNumber: get current committee number

:
- [PaymentTransactionUsage](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/PaymentTransactionUsage.java)
sendPaymentTx: send payment transaction

wrap method:
sign trueRawTransaction with privateKey of from address :
signWithFromPrivateKey()

sign signedTxWithFrom with privatekey of payment address:
signPaymentTxWithPaymentAndSend(signedTxWithFrom)
