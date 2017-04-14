//
//  EventTableViewCell.m
//  EventPal
//
//  Created by Yan Kononov on 09/04/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import "EventTableViewCell.h"

@interface EventTableViewCell()
@property (weak, nonatomic) IBOutlet UILabel *titleLabel;
@property (weak, nonatomic) IBOutlet UILabel *AddressLabel;
@end

@implementation EventTableViewCell

- (void)awakeFromNib {
    [super awakeFromNib];
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

-(void)setData:(NSString*)title andAddress:(NSString*)address{
    _titleLabel.text = title;
    _AddressLabel.text = address;
}

@end
