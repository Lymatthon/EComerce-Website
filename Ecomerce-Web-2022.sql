-- insert to category table --
INSERT INTO `dbminishop`.`category` (`categoryId`, `categoryName`, `description`) VALUES ('1', 'Women', 'Cloth for mordern woman');
INSERT INTO `dbminishop`.`category` (`categoryId`, `categoryName`, `description`) VALUES ('2', 'Man', 'For Man');
INSERT INTO `dbminishop`.`category` (`categoryId`, `categoryName`, `description`) VALUES ('3', 'Kid', 'Cloth for Kid');
INSERT INTO `dbminishop`.`category` (`categoryId`, `categoryName`, `description`) VALUES ('4', 'Accessory', 'Accessory');
-- insert to role table --
INSERT INTO `dbminishop`.`role` (`roleId`, `role`) VALUES ('1', 'Admin');
INSERT INTO `dbminishop`.`role` (`roleId`, `role`) VALUES ('2', 'User');
INSERT INTO `dbminishop`.`role` (`roleId`, `role`) VALUES ('3', 'Seller');
-- insert to image table --
INSERT INTO `dbminishop`.`image` (`imageId`, `imageName`) VALUES ('1', 'item1');
INSERT INTO `dbminishop`.`image` (`imageId`, `imageName`) VALUES ('2', 'item2');
INSERT INTO `dbminishop`.`image` (`imageId`, `imageName`) VALUES ('3', 'item3');
-- insert to product table --
INSERT INTO `dbminishop`.`product` (`productId`, `description`, `price`, `productName`, `categoryId`, `imageId`) VALUES ('1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '12.99', 'Cool Clothing with Brown Stripes', '1', '1');
INSERT INTO `dbminishop`.`product` (`productId`, `description`, `price`, `productName`, `categoryId`, `imageId`) VALUES ('2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '4', 'Long Sleeve Jacket', '1', '2');
INSERT INTO `dbminishop`.`product` (`productId`, `description`, `price`, `productName`, `categoryId`, `imageId`) VALUES ('3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '5', 'Hype Grey Shirt', '3', '3');
INSERT INTO `dbminishop`.`product` (`productId`, `description`, `price`, `productName`, `categoryId`, `imageId`) VALUES ('4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '6', 'Long Red Shirt', '2', '1');
INSERT INTO `dbminishop`.`product` (`productId`, `description`, `price`, `productName`, `categoryId`, `imageId`) VALUES ('5', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '4.9', 'Long Red Shirt', '4', '2');
INSERT INTO `dbminishop`.`product` (`productId`, `description`, `price`, `productName`, `categoryId`, `imageId`) VALUES ('6', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '5.99', 'Long Red Shirt', '4', '3');
UPDATE `dbminishop`.`product` SET `dateCreate` = '2022-06-01' WHERE (`productId` = '1');
UPDATE `dbminishop`.`product` SET `dateCreate` = '2022-06-02' WHERE (`productId` = '2');
UPDATE `dbminishop`.`product` SET `dateCreate` = '2022-06-08' WHERE (`productId` = '3');
UPDATE `dbminishop`.`product` SET `dateCreate` = '2022-06-10' WHERE (`productId` = '4');
UPDATE `dbminishop`.`product` SET `dateCreate` = '2022-06-18' WHERE (`productId` = '5');
UPDATE `dbminishop`.`product` SET `dateCreate` = '2022-06-08' WHERE (`productId` = '6');

-- insert to color table --
INSERT INTO `dbminishop`.`color` (`colorId`, `color`) VALUES ('1', 'Black');
INSERT INTO `dbminishop`.`color` (`colorId`, `color`) VALUES ('2', 'Red');
INSERT INTO `dbminishop`.`color` (`colorId`, `color`) VALUES ('3', 'Gray');
INSERT INTO `dbminishop`.`color` (`colorId`, `color`) VALUES ('4', 'Yellow');
INSERT INTO `dbminishop`.`color` (`color`) VALUES ('Brown');
INSERT INTO `dbminishop`.`color` (`color`) VALUES ('Orange');
INSERT INTO `dbminishop`.`color` (`color`) VALUES ('Green');
INSERT INTO `dbminishop`.`color` (`color`) VALUES ('Purple');
INSERT INTO `dbminishop`.`color` (`color`) VALUES ('Blue');
-- insert to size table --
INSERT INTO `dbminishop`.`sizetable` (`sizeId`, `productSize`) VALUES ('1', 'XS');
INSERT INTO `dbminishop`.`sizetable` (`sizeId`, `productSize`) VALUES ('3', 'S');
INSERT INTO `dbminishop`.`sizetable` (`productSize`) VALUES ('M');
INSERT INTO `dbminishop`.`sizetable` (`productSize`) VALUES ('L');
INSERT INTO `dbminishop`.`sizetable` (`productSize`) VALUES ('XL');
INSERT INTO `dbminishop`.`sizetable` (`sizeId`, `productSize`) VALUES ('2', 'XXL');
-- insert to product detail table --
INSERT INTO `dbminishop`.`productdetail` (`pDetailId`, `description`, `quantity`, `colorId`, `productId`, `sizeId`) VALUES ('1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '3', '2', '1', '3');
INSERT INTO `dbminishop`.`productdetail` (`description`, `quantity`, `colorId`, `productId`, `sizeId`) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '12', '3', '1', '1');
INSERT INTO `dbminishop`.`productdetail` (`description`, `quantity`, `colorId`, `productId`, `sizeId`) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '10', '4', '2', '4');
INSERT INTO `dbminishop`.`productdetail` (`description`, `quantity`, `colorId`, `productId`, `sizeId`) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '5', '1', '3', '5');
INSERT INTO `dbminishop`.`productdetail` (`description`, `quantity`, `colorId`, `productId`, `sizeId`) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '6', '6', '4', '2');
INSERT INTO `dbminishop`.`productdetail` (`description`, `quantity`, `colorId`, `productId`, `sizeId`) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '7', '5', '5', '6');




