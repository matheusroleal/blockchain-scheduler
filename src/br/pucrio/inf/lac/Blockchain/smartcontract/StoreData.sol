pragma solidity ^0.5.12;

contract StoreData {

    // Data related to the transaction
    mapping (string => bool) private transaction;
    mapping (string => string) private data;

    string transactions;

    function setTransaction(string memory data_to_send) public {
        // Change sender to string
        string memory transaction_sender = toString(msg.sender);
        // Concatenate sender and time in one string
        string memory transaction_id = string(abi.encodePacked(transaction_sender,Time_call()));
        // Add transaction info in maps
        transaction[transaction_id] = true;
        data[transaction_id] = data_to_send;
        // Store data of the transaction
        transactions = strConcat(transactions,transaction_id);
    }

    function getTransctions() public returns(string memory){
        return transactions;
    }

    function getData(string memory tran_id) public returns (string memory){
        require(transaction[tran_id] == true, "No Data Found For This Transaction");
        return data[tran_id];
    }

    // Utils function
    function toString(address x)private returns (string memory) {
        bytes memory b = new bytes(20);
        for (uint i = 0; i < 20; i++){
            b[i] = byte(uint8(uint(x) / (2**(8*(19 - i)))));
        }
        return string(b);
    }

    function Time_call()private returns (uint256){
        return now;
    }
    
    function strConcat(string memory _a, string memory _b) internal returns (string memory){
	    bytes memory _ba = bytes(_a);
	    bytes memory _bb = bytes(_b);
	    string memory ab = new string(_ba.length + _bb.length);
	    bytes memory bab = bytes(ab);
	    uint k = 0;
	    for (uint i = 0; i < _ba.length; i++) bab[k++] = _ba[i];
	    for (uint i = 0; i < _bb.length; i++) bab[k++] = _bb[i];
	    return string(bab);
	}
    

}
