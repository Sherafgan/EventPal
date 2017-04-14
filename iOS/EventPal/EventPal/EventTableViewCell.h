//
//  EventTableViewCell.h
//  EventPal
//
//  Created by Yan Kononov on 09/04/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface EventTableViewCell : UITableViewCell
-(void)setData:(NSString*)title andAddress:(NSString*)address;
@end
