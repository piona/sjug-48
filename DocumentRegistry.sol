pragma solidity >=0.4.0 <0.7.0;

contract DocumentRegistry {
    struct Document {
        uint hash;
        uint time;
    }

    uint[] public documentsIds;
    mapping(uint => Document) public documents;

    function registerDocument(uint _id, uint _hash) public {
        require(!isDocumentExists(_id));
        documentsIds.push(_id);
        documents[_id].hash = _hash;
        documents[_id].time = now;
        emit DocumentRegistration(msg.sender, _id, _hash);
    }

    function getDocumentsCount() public view returns(uint count) {
        return documentsIds.length;
    }

    function isDocumentExists(uint _id) public view returns(bool exists) {
        return documents[_id].time != 0;
    }

    event DocumentRegistration(address _who, uint _id, uint _hash);
}
