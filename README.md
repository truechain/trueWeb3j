# trueWeb3j
Truechain RPC service interface call based on Web3j


RPC interface name and specification:

- [FastBlock](https://github.com/truechain/trueWeb3j/blob/master/src/main/java/com/trueweb3j/sample/FastBlockUsage.java)
getFastBlockByNumber: get FastBlock by fastNumber
getCurrentFastNumber: get current fastNumber on the chain

Balance or Reward:
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

CommitteeInfo:
getCommitteeByNumber:  get committeeInfo by committeeNumber
getCurrentCommitteeNumber: get current committee number

Transaction:
etrueSendRawTransaction: send payment transaction


wrap method:

sign trueRawTransaction with privateKey of from address :
signWithFromPrivateKey(trueRawTransaction, String fromPrivateKey)

sign signedTxWithFrom with privatekey of payment address:
signWithPaymentPrivateKey(signedTxWithFrom,paymentPrivateKey)

sign signedTxWithFrom with privatekey of payment address and send transaction to chain network:
signWithPaymentAndSend(signedTxWithFrom,paymentPrivateKey)


sign with from and payment private
signWithFromAndPayment(trueRawTransaction,fromPrivateKey,paymentPrivateKey)