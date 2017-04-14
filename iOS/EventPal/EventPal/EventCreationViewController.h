//
//  EventCreationViewController.h
//  EventPal
//
//  Created by Yan Kononov on 08/04/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Event.h"

@interface EventCreationViewController : UIViewController
@property (strong, nonatomic) NSString *name;
@property (strong, nonatomic) NSString *address;
@property (strong, nonatomic) Event *event;
-(void)setData:(NSString*) name andAddress:(NSString*)address;
@end
