setup-smartcontract:
	@npm install -g web3 
	@npm install -g ganache-cli 
	@npm install -g solc@0.5.12

build-smartcontract:
	@solc src/br/pucrio/inf/lac/Blockchain/smartcontract/StoreData.sol --bin --abi --optimize -o .
	@mv src_br_pucrio_inf_lac_Blockchain_smartcontract_StoreData_sol_StoreData.abi src/br/pucrio/inf/lac/Blockchain/smartcontract/StoreData.abi
	@mv src_br_pucrio_inf_lac_Blockchain_smartcontract_StoreData_sol_StoreData.bin src/br/pucrio/inf/lac/Blockchain/smartcontract/StoreData.bin
	@web3j generate solidity -b src/br/pucrio/inf/lac/Blockchain/smartcontract/StoreData.bin  -a src/br/pucrio/inf/lac/Blockchain/smartcontract/StoreData.abi -o .  -p br.pucrio.inf.lac.Blockchain.smartcontract
	@mv br/pucrio/inf/lac/Blockchain/smartcontract/StoreData.java src/br/pucrio/inf/lac/Blockchain/smartcontract/StoreData.java
	@rm -rf br/
