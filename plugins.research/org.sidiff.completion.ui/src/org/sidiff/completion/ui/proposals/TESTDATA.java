package org.sidiff.completion.ui.proposals;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class TESTDATA {

	public static ICompletionProposal[] getProposals() {
		return new ICompletionProposal[] { 

				new ICompletionProposal() {

					@Override
					public ICompletionPreview preview() {
						return new ICompletionPreview() {
							
							@Override
							public boolean show() {
								System.out.println("show preview()" + toString());
								return true;
							}
							
							@Override
							public boolean hide() {
								System.out.println("hide preview()" + toString());
								return true;
							}
						};
					}

					@Override
					public String getText() {
						return "Name:" + toString();
					}

					@Override
					public String getInformation() {
						return "Information" + toString();
					}

					@Override
					public Image getImage() {
						return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
					}

					@Override
					public boolean apply() {
						System.out.println("apply()" + toString());
						return false;
					}
				},

				new ICompletionProposal() {

					@Override
					public ICompletionPreview preview() {
						return new ICompletionPreview() {
							
							@Override
							public boolean show() {
								System.out.println("show preview()" + toString());
								return true;
							}
							
							@Override
							public boolean hide() {
								System.out.println("hide preview()" + toString());
								return true;
							}
						};
					}

					@Override
					public String getText() {
						return "Name:" + toString();
					}

					@Override
					public String getInformation() {
						return "Information" + toString();
					}

					@Override
					public Image getImage() {
						return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
					}

					@Override
					public boolean apply() {
						System.out.println("apply()" + toString());
						return false;
					}
				},

				// Without information:
				new ICompletionProposal() {

					@Override
					public ICompletionPreview preview() {
						return new ICompletionPreview() {
							
							@Override
							public boolean show() {
								System.out.println("show preview()" + toString());
								return true;
							}
							
							@Override
							public boolean hide() {
								System.out.println("hide preview()" + toString());
								return true;
							}
						};
					}

					@Override
					public String getText() {
						return "Name:" + toString();
					}

					@Override
					public String getInformation() {
						return null;
					}

					@Override
					public Image getImage() {
						return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
					}

					@Override
					public boolean apply() {
						System.out.println("apply()" + toString());
						return false;
					}
				},
				
				new ICompletionProposal() {

					@Override
					public ICompletionPreview preview() {
						return new ICompletionPreview() {
							
							@Override
							public boolean show() {
								System.out.println("show preview()" + toString());
								return true;
							}
							
							@Override
							public boolean hide() {
								System.out.println("hide preview()" + toString());
								return true;
							}
						};
					}

					@Override
					public String getText() {
						return "Name:" + toString();
					}

					@Override
					public String getInformation() {
						return "Information" + toString();
					}

					@Override
					public Image getImage() {
						return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
					}

					@Override
					public boolean apply() {
						System.out.println("apply()" + toString());
						return false;
					}
				}
		};
	}
}
