pragma solidity >=0.4.0 <0.7.0;

contract Token {
    mapping (address => uint256) public balanceOf;

    constructor(uint256 initialSupply) public {
	balanceOf[msg.sender] = initialSupply;
    }

   function transfer(address _to, uint256 _value) public {
        balanceOf[msg.sender] -= _value;
        balanceOf[_to] += _value;
    }
}

